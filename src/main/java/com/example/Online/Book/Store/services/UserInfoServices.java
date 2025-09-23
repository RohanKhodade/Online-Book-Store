package com.example.Online.Book.Store.services;

import com.example.Online.Book.Store.dto.UserInfoDto;

public interface UserInfoServices {
    public UserInfoDto createUser(UserInfoDto userInfoDto);
    public String getUserInfo(String userName);
}
