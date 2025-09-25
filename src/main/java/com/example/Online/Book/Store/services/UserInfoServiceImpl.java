package com.example.Online.Book.Store.services;

import com.example.Online.Book.Store.dto.UserInfoDto;
import com.example.Online.Book.Store.entity.UserInfo;
import com.example.Online.Book.Store.mapper.UserInfoMapper;
import com.example.Online.Book.Store.repo.UserInfoRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoServices{
    UserInfoRepo userInfoRepo;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    JwtService jwtService;
    public UserInfoServiceImpl(UserInfoRepo userInfoRepo,
                               PasswordEncoder passwordEncoder,
                               AuthenticationManager authenticationManager,
                               JwtService jwtService){
        this.userInfoRepo=userInfoRepo;
        this.passwordEncoder=passwordEncoder;
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
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
    public String getUserInfo(UserInfoDto userInfoDto){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userInfoDto.username(),userInfoDto.password())
                );
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(userInfoDto.username());
        }
        return "Failure";
    }
}
