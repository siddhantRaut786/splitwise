package com.example.splitwise.commands;

public interface Command {

    boolean canExecute(String input);

    void execute(String input);
}
