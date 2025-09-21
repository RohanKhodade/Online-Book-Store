package com.example.Online.Book.Store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    // create book , delete, find, add
    @GetMapping("/{BookId}")
    public ResponseEntity<String> findBook(@PathVariable String BookId){
        return new ResponseEntity<>("Book found" + BookId, HttpStatus.OK);
    }
}
