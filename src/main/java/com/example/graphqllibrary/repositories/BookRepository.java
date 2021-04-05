package com.example.graphqllibrary.repositories;

import com.example.graphqllibrary.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
