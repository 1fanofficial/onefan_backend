package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.model.request.UserDetailsRequest;
import com.onefanofficial.onefan_backend.model.response.UserResponse;
import com.onefanofficial.onefan_backend.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name="User apis", description = "create, update and delete user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public ResponseEntity<UserResponse> updateUserDetails(@RequestBody UserDetailsRequest userDetailsRequest){
        return ResponseEntity.ok(userService.saveUserDetails(userDetailsRequest));
    }

}
