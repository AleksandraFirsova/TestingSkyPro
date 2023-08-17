package com.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class UserTest {

    String login = "testUser";
    String email = "test@test.com";

    @CsvSource(value = {
            "testUser, test@test.com, testUser, test@test.com",
            "null, null, null, null"
    })
    @ParameterizedTest(name = "Создание user с параметрами логин {2} и email {3}")
    void testUserCreationWithParameters(String login, String email, String expectedLogin, String expectedEmail) {
        User user = new User(login, email);

        Assertions.assertEquals(expectedLogin, user.getLogin());
        Assertions.assertEquals(expectedEmail, user.getEmail());
    }

    @Test
    @DisplayName("Создание user без параметров")
    public void testUserCreationWithoutParameters() {
        User user = new User();

        Assertions.assertNull(user.getLogin());
        Assertions.assertNull(user.getEmail());
    }

    @ValueSource(strings = {
            "@",
            "."
    })
    @ParameterizedTest(name = "Email содержит символ {0}")
    public void testCorrectEmail(String value) {
        User user = new User(login, email);
        Assertions.assertTrue(user.getEmail().contains(value));
    }

    @Test
    @DisplayName("Логин и email не равны")
    public void testLoginAndEmailEquality() {
        User user = new User(login, email);
        Assertions.assertNotEquals(user.getLogin(), user.getEmail());
    }
}
