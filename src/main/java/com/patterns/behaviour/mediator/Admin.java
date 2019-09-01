package com.patterns.behaviour.mediator;

public class Admin extends User {
    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    public void getMessage(String message) {
        System.out.println("Administrator " + getName() + " gets message " + message + "'");
    }
}
