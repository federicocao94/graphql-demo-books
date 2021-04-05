package com.example.graphqllibrary.services;

import com.example.graphqllibrary.model.Book;
import com.example.graphqllibrary.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Transactional
    public Book createBook(String title, String author, String genre, String launchDate) {

        Date lDate = null;
        if(launchDate != null && !"".equals(launchDate)) {
            try {
                lDate = new SimpleDateFormat("dd/MM/yyyy").parse(launchDate);
            } catch (Exception e) {
                log.error("Error converting launchDate: " + e.getMessage());
            }
        }

        Book book = Book.builder()
                .title(title)
                .author(author)
                .genre(genre)
                .launchDate(lDate)
                .build();

        return bookRepository.save(book);
    }


    public List<Book> getAllBooks(int count) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);
        return bookList.stream().limit(count).collect(Collectors.toList());
    }


    public Book getBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }

}
