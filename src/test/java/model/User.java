package model;

import java.util.Objects;

public class User {
    private String name;
    private String password;

    public User (String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getUserName(){
        return name;
    }

    public void setUserName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    @Override
    public String toString(){
        return "User{"+
                "name='" + name + '\''+
                "password='" + password + '\''+
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User user = (User) obj;
        return Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getUserName(), getPassword());
    }
}
