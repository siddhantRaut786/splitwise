package com.example.splitwise.services.passwordencoder;

public interface PasswordEncoder {

    String getEncodedPassword(String realPassword);

    boolean matches(String realPassword, String hashedPassword);
}
