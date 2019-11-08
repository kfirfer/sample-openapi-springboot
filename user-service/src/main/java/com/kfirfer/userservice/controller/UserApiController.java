package com.kfirfer.userservice.controller;

import com.kfirfer.userservice.api.UserApi;
import com.kfirfer.userservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserApiController implements UserApi {

    @Override
    public ResponseEntity<Void> createUser(@Valid @RequestBody User body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> createUsersWithArrayInput(@Valid List<User> body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> createUsersWithListInput(@Valid List<User> body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        return null;
    }

    @Override
    public ResponseEntity<String> loginUser(@Valid String username, @Valid String password) {
        return null;
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, @Valid User body) {
        return null;
    }
}
