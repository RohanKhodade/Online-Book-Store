package com.example.Online.Book.Store.mapper;

import com.example.Online.Book.Store.dto.UserInfoDto;
import com.example.Online.Book.Store.entity.UserInfo;

public class UserInfoMapper {
    public static UserInfoDto toUserInfoDto(UserInfo userInfo){
        return new UserInfoDto(userInfo.getUsername(),userInfo.getPassword(),userInfo.getRoles());
    }
    public static UserInfo toUserInfo(UserInfoDto userInfoDto){
        UserInfo user=new UserInfo();
        user.setUsername(userInfoDto.username());
        user.setPassword(userInfoDto.password());
        user.setRoles(userInfoDto.roles());
        return user;
    }
}
