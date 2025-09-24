package com.example.Online.Book.Store.services;

import com.example.Online.Book.Store.entity.UserInfo;
import com.example.Online.Book.Store.mapper.UserInfoDetailsMapper;
import com.example.Online.Book.Store.repo.UserInfoRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// class to get user from database as a userDetailsService so that spring security understands user
public class UserInfoUserDetailsServiceImpl implements UserDetailsService {

    UserInfoRepo userInfoRepo;
    public UserInfoUserDetailsServiceImpl (UserInfoRepo userInfoRepo){
        this.userInfoRepo=userInfoRepo;
    }

    // load the user from database if not then return exception and string
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user=userInfoRepo.findByUsername(username);
        if (user.isPresent()) {
            return new UserInfoDetailsMapper(user.get());
        }else{
            throw new UsernameNotFoundException("user: "+ username+ " not found ");
        }
    }
}
