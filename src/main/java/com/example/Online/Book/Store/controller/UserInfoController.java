package com.example.Online.Book.Store.controller;

import com.example.Online.Book.Store.dto.UserInfoDto;
import com.example.Online.Book.Store.entity.UserInfo;
import com.example.Online.Book.Store.services.UserInfoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    UserInfoServices userInfoServices;
    public UserInfoController(UserInfoServices userInfoServices){
        this.userInfoServices=userInfoServices;
    }

    @PostMapping("/login")
    public ResponseEntity<String> getUser(@RequestBody UserInfoDto userInfoDto){
        return new ResponseEntity<>(userInfoServices.getUserInfo(userInfoDto),HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserInfoDto userInfoDto){
        UserInfoDto userDto=userInfoServices.createUser(userInfoDto);
        if (userDto!=null){
            return  ResponseEntity.ok(
                    Map.of(userDto, "user registered successfully")
            );
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("message","User already exists"));
    }
}
