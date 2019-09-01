package com.patterns.behaviour.mediator;

public class SimpleUser extends User {
    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    public void getMessage(String message) {
        System.out.println("User " + getName() + "get message" + message + "'");
    }
}
