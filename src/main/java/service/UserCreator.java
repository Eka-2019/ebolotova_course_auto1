package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME = System.getProperty("login");
    public static final String USER_PASSWORD = System.getProperty("password");

    public static User withCredentialsFromProperty(){
        return new User(USER_NAME, USER_PASSWORD);
    }

    public static User withEmptyUserName(){
        return new User("", USER_PASSWORD);
    }

    public static User withEmptyUserPassword(){
        return new User(USER_NAME, "");
    }
}
