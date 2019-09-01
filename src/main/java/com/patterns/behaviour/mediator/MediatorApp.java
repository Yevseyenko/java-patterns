package com.patterns.behaviour.mediator;

public class MediatorApp {
    public static void main(String [] args){
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Ivan Ivanovich");
        User u1 = new SimpleUser(chat,"Ivan");
        User u2 = new SimpleUser(chat,"Vovan");
        User u3 = new SimpleUser(chat,"Oleksandr");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        admin .sendMessage("Hello");
    }
}
