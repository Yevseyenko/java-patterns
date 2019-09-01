package com.patterns.behaviour.mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("You have no rights");
        }
    }

    public void addUser(User u) {
        if (admin == null) {
            throw new RuntimeException("There is no admin");
        }
        if (u instanceof SimpleUser) {
            users.add(u);
        } else {
            throw new RuntimeException("Admin can't login to another chat");
        }
    }

    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }
        if(user instanceof SimpleUser){
            for (User u :users){
                if(u!=user && u.isEnable())
                    u.getMessage(user.getName()+": "+message);
            }
            if (admin.isEnable())
                admin.getMessage(user.getName()+": "+message);
        }
    }
}
