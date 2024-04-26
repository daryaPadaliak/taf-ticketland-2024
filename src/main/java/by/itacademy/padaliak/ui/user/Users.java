package by.itacademy.padaliak.ui.user;

import com.github.javafaker.Faker;

public class Users {
    public static User getUserByEmail() {
        Faker faker = new Faker();
        return new User(faker.internet().emailAddress(), faker.internet().password());
    }

    public static User getUserByName() {
        Faker faker = new Faker();
        return new User(faker.name().firstName(), faker.internet().password());
    }

}