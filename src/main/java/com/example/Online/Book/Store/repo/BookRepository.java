package com.example.Online.Book.Store.repo;

import com.example.Online.Book.Store.entity.Book;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface BookRepository extends MongoRepository<Book,String> {

    @Query("{bookId: ?0}")
    Book findBookByBookId(String bookId);

    @Query("{bookId : ?0}")
    @Update("{'$set':{'name': ?1}}")
    void updateBookNameByBookId(String bookId,String name);

    @DeleteQuery
    void deleteBookByBookId(String bookId);
}
