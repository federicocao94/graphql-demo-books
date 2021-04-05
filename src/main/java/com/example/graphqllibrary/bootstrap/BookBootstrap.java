package com.example.graphqllibrary.bootstrap;

import com.example.graphqllibrary.model.Book;
import com.example.graphqllibrary.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class BookBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final BookRepository bookRepository;

    public BookBootstrap(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        bookRepository.saveAll(getBooks());
        log.info("Loading bootstrap data " + bookRepository.count());
    }


    private List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        books.add(Book.builder()
                .id(1)
                .title("Libro 1")
                .author("Author")
                .build());

        books.add(Book.builder()
                .id(2)
                .title("Libro 2")
                .author("Author")
                .genre("Sci-Fi")
                .launchDate(new Date())
                .build());

        books.add(Book.builder()
                .id(3)
                .title("Libro 3")
                .author("Author")
                .genre("Fiction")
                .launchDate(new Date())
                .build());

        return books;
    }

}
