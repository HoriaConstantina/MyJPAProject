package com.sparta.hc.services;

import com.sparta.hc.components.User;

public class LoginService {

    public String validateUser(User user) {

        if (user.getUserName().equals("test") && user.getPassword().equals("test")){
            return "welcome";
        }
        else {
            return "login";
        }
    }
}
