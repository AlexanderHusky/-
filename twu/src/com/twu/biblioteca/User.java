package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String account;
    private String password;
    private String name;
    private String email;
    private int phone_num;
    public List<Book> pickup_booklist;
    public List<Book> bought_booklist;
    public List<Movie> pickup_movielist;
    public List<Movie> bought_movielist;


    public User(){};
    public User(String account, String password, String name, String email, int phone_num) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone_num = phone_num;
        this.pickup_booklist = new ArrayList<>();
        this.bought_booklist = new ArrayList<>();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBought_booklist() {
        return bought_booklist;
    }

    public void setBought_booklist(List<Book> bought_booklist) {
        this.bought_booklist = bought_booklist;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }
}
