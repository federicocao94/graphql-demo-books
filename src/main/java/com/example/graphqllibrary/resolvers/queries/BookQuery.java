package com.example.graphqllibrary.resolvers.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqllibrary.model.Book;
import com.example.graphqllibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery implements GraphQLQueryResolver {

    private BookService bookService;

    @Autowired
    public BookQuery(BookService bookService) {
        this.bookService = bookService;
    }


    public List<Book> getBooks(int count) {
        return bookService.getAllBooks(count);
    }


    public Book getBook(int id) {
        return bookService.getBook(id);
    }

}
