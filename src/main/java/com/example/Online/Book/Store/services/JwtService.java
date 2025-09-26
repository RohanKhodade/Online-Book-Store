package com.example.Online.Book.Store.services;

public interface JwtService {
    public String generateToken(String username);
    public String extractUsername(String jwtToken);
}
