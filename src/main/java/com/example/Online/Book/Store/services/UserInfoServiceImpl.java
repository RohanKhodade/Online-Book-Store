package com.example.Online.Book.Store.services;

import com.example.Online.Book.Store.dto.UserInfoDto;
import com.example.Online.Book.Store.entity.UserInfo;
import com.example.Online.Book.Store.mapper.UserInfoMapper;
import com.example.Online.Book.Store.repo.UserInfoRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoServices{
    UserInfoRepo userInfoRepo;
    PasswordEncoder passwordEncoder;
    public UserInfoServiceImpl(UserInfoRepo userInfoRepo,PasswordEncoder passwordEncoder){
        this.userInfoRepo=userInfoRepo;
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto){
        Optional<UserInfo> existingUser=userInfoRepo.findByUsername(userInfoDto.username());
        if (existingUser.isPresent()){
            return null;
        }
        UserInfo user=new UserInfo();
        user.setUsername(userInfoDto.username());
        user.setPassword(passwordEncoder.encode(userInfoDto.password()));
        user.setRoles(userInfoDto.roles());

        UserInfo savedUser=userInfoRepo.save(user);
        return UserInfoMapper.toUserInfoDto(savedUser);
    }
    @Override
    public String getUserInfo(String userName){
        Optional<UserInfo> user=userInfoRepo.findByUsername(userName);
        if (user.isPresent()){
            UserInfoDto userDto=UserInfoMapper.toUserInfoDto(user.get());
            String userString="";
            userString=userDto.username()+ " "+ " "+userDto.roles();
            return userString;
        }
        return "";
    }
}
