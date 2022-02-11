package com.contohdi.demo.service.impl;

import com.contohdi.demo.entity.Book;
import com.contohdi.demo.repository.BookRepository;
import com.contohdi.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Long bookId) {
        return repository.findById(bookId)
                .orElseThrow(()-> new EntityNotFoundException("Data gak ada bos"));
    }

    @Override
    public List<Book> getAllBook() {
        return repository.findAll();
    }
}
