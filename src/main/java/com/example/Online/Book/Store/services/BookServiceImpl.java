package com.example.Online.Book.Store.services;

import com.example.Online.Book.Store.dto.BookDto;
import com.example.Online.Book.Store.entity.Book;
import com.example.Online.Book.Store.mapper.Mapper;
import com.example.Online.Book.Store.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookServices{
    BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public BookDto getBook(String bookId){
        Book book=bookRepository.findBookByBookId(bookId);
        BookDto bookDto= Mapper.toBookDto(book);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks(){
        List<Book> books=bookRepository.findAll();
        List<BookDto> bookDto=new ArrayList<>();
        for (Book book :books){
            bookDto.add(Mapper.toBookDto(book));
        }
        return bookDto;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book=Mapper.toBook(bookDto);
        bookRepository.insert(book);
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto){
        Book book=Mapper.toBook(bookDto);
        bookRepository.updateBookNameByBookId(book.bookId(),book.name());
        return Mapper.toBookDto(bookRepository.findBookByBookId(book.bookId()));
    }

    @Override
    public void deleteBook(String bookId){
        bookRepository.deleteBookByBookId(bookId);
    }

}
