package com.onefanofficial.onefan_backend.controller;

import com.onefanofficial.onefan_backend.configuration.ExceptionHandler.Exceptions.UnauthorizedException;
import com.onefanofficial.onefan_backend.configuration.annotations.CustomUser.CurrentUser;
import com.onefanofficial.onefan_backend.model.request.UserDetailsRequest;
import com.onefanofficial.onefan_backend.model.response.UserResponse;
import com.onefanofficial.onefan_backend.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name="User apis", description = "create, update and delete user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public ResponseEntity<UserResponse> updateUserDetails(@CurrentUser String userId, @RequestBody UserDetailsRequest userDetailsRequest){
        if(!userId.equals(userDetailsRequest.getId().toString())){
            throw new UnauthorizedException("UNAUTHORIZED ACTION");
        }
        return ResponseEntity.ok(userService.saveUserDetails(userDetailsRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserDetails(@CurrentUser String userId, @PathVariable String id){
        if(!userId.equals(id)){
            throw new UnauthorizedException("UNAUTHORIZED ACTION");
        }
        return ResponseEntity.ok(userService.getUserById(id));
    }


}
