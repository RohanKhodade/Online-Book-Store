package com.example.Online.Book.Store.controller;

import com.example.Online.Book.Store.dto.BookDto;
import com.example.Online.Book.Store.services.BookServices;
import com.oracle.svm.core.annotate.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    BookServices bookServices;
    public BookController(BookServices bookServices){
        this.bookServices=bookServices;
    }
    @GetMapping("/")
    public ResponseEntity<String> greet(){
        return new ResponseEntity<>("Hello User ! YOU are now Logged in",HttpStatus.OK);
    }
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome to the book store",HttpStatus.OK);
    }
    // create book , delete, find, add
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findBook(@PathVariable String bookId){
        BookDto bookdto=bookServices.getBook(bookId);
        return new ResponseEntity<>(bookdto, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> bookDtoList=bookServices.getAllBooks();
        return new ResponseEntity<>(bookDtoList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto bookdto=bookServices.createBook(bookDto);
        return new ResponseEntity<>(bookdto,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
        BookDto bookdto=bookServices.updateBook(bookDto);
        return new ResponseEntity<>(bookdto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        bookServices.deleteBook(bookId);
        return new ResponseEntity<>("Book Deleted Successfully", HttpStatus.OK);
    }
}
