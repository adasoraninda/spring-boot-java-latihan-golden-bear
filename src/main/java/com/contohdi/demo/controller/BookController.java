package com.contohdi.demo.controller;

import com.contohdi.demo.dto.BookRequest;
import com.contohdi.demo.entity.Book;
import com.contohdi.demo.model.BaseResponse;
import com.contohdi.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private Book mBook;

    @PostMapping
    ResponseEntity<BaseResponse<Book>> postBook(@RequestBody BookRequest bookRequest) {
        mBook.setId(1000L);
        mBook.setTitle("Test");

        System.out.println("Post: " + mBook);

        Book book = new Book(null, bookRequest.getTitle());
        Book result = service.createBook(book);
        BaseResponse<Book> resultBase = new BaseResponse<>(
                HttpStatus.OK.value(),
                "Berhasil",
                result);

        return ResponseEntity.ok(resultBase);
    }

    @GetMapping
    ResponseEntity<BaseResponse<List<Book>>> getAllBook() {
        System.out.println("Get All: " + mBook);

        List<Book> results = service.getAllBook();
        BaseResponse<List<Book>> resultBase = new BaseResponse<>(
                HttpStatus.OK.value(),
                "Berhasil",
                results);

        return ResponseEntity.ok(resultBase);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<BaseResponse<Book>> getBookById(
            @PathVariable(value = "id") Long bookId
    ) {
        Book result = service.getBookById(bookId);
        BaseResponse<Book> resultBase = new BaseResponse<>(
                HttpStatus.OK.value(),
                "Berhasil",
                result);

        return ResponseEntity.ok(resultBase);
    }

}
