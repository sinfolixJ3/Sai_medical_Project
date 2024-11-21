package com.sinfolix.Sai_Samarth.service.Impl;

import com.sinfolix.Sai_Samarth.entities.User;
import com.sinfolix.Sai_Samarth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void processOAuthPostLogin(OAuth2AuthenticationToken authenticationToken) {
        String email = authenticationToken.getPrincipal().getAttribute("email");
        String name = authenticationToken.getPrincipal().getAttribute("name");
        String picture = authenticationToken.getPrincipal().getAttribute("picture");

        User existingUser = userRepository.findByEmail(email);
        if (existingUser == null) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setPicture(picture);
            userRepository.save(newUser);
        }
    }
}
