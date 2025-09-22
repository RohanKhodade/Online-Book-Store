package com.example.Online.Book.Store.mapper;

import com.example.Online.Book.Store.dto.BookDto;
import com.example.Online.Book.Store.entity.Book;

public class Mapper {

    public static Book toBook(BookDto bookDto){
        Book newBook=new Book(bookDto.bookId(),bookDto.name(),bookDto.price(),
                bookDto.author(),bookDto.description());

        return newBook;
    }
    public static BookDto toBookDto(Book book){
        BookDto bookDto=new BookDto(book.bookId(),book.name(),
                book.price(),book.author(),book.description());
        return bookDto;
    }

}
