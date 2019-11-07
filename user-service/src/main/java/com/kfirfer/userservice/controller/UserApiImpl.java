package com.kfirfer.userservice.controller;

import com.kfirfer.userservice.api.UserApi;
import com.kfirfer.userservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiImpl implements UserApi {

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
