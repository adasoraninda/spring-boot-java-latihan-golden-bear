package com.contohdi.demo.service;

import com.contohdi.demo.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book getBookById(Long bookId);

    List<Book> getAllBook();

}
