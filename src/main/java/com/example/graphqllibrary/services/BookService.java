package com.example.graphqllibrary.services;

import com.example.graphqllibrary.model.Book;

import java.util.List;

public interface BookService {

    Book createBook(String title, String author, String genre, String launchDate);

    List<Book> getAllBooks(int count);

    Book getBook(int id);

}
