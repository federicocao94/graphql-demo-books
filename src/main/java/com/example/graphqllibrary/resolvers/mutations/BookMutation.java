package com.example.graphqllibrary.resolvers.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqllibrary.model.Book;
import com.example.graphqllibrary.services.BookService;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    private BookService bookService;

    public BookMutation (BookService bookService) {
       this.bookService = bookService;
    }


    public Book createBook(String title, String author, String genre, String launchDate) {
        return bookService.createBook(title, author, genre, launchDate);
    }

}
