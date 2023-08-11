package com.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class UserTest {
    String expectedLogin = "testUser";
    String expectedEmail = "test@test.com";

    String login = "testUser";
    String email = "test@test.com";

    @Test
    @DisplayName("Создание user без параметров")
    void testUserCreationWithParameters() {
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
