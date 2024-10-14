package com.demowebshop.model;

public class User {
    private String email;
    private String password;

    // Конструктор без параметров
    public User() {
    }

    // Конструктор с параметрами
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Сеттер для email
    public User setEmail(String email) {
        this.email = email;
        return this;  // Возвращаем объект для удобной цепочки вызовов
    }

    // Сеттер для password
    public User setPassword(String password) {
        this.password = password;
        return this;  // Возвращаем объект для удобной цепочки вызовов
    }

    // Геттер для email
    public String getEmail() {
        return email;
    }

    // Геттер для password
    public String getPassword() {
        return password;
    }
}
