package com.example.Online.Book.Store.services;

import com.example.Online.Book.Store.dto.BookDto;
import com.example.Online.Book.Store.entity.Book;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface BookServices {
    public BookDto getBook (String bookId);
    public List<BookDto> getAllBooks();
    public BookDto createBook(BookDto bookdto);
    public BookDto updateBook(BookDto bookDto);
    public void deleteBook(String bookId);
}
