package com.contohdi.demo.configuration;

import com.contohdi.demo.entity.Book;
import com.contohdi.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class PrePopulateData {

    @Bean
    CommandLineRunner runner(BookRepository repository) {
        var book1 = new Book(null, "Buku 1");
        var book2 = new Book(null, "Buku 2");

        return args -> repository.saveAll(List.of(book1, book2));
    }

}
