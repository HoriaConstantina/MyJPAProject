package com.sparta.hc.services;

import com.sparta.hc.components.User;



import javax.inject.Named;

@Named
public class RegistrationService {
    public String registerUser(User user) {
        return "login";
    }
}
