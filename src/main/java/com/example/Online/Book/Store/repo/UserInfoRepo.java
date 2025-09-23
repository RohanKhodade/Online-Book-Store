package com.example.Online.Book.Store.repo;

import com.example.Online.Book.Store.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepo extends MongoRepository<UserInfo,String> {
    Optional<UserInfo> findByUsername(String userName);
}
