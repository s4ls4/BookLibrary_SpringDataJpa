package client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import web.dto.BookDto;
import web.dto.BooksDto;

public class ClientApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "client.config"
                );

        RestTemplate restTemplate = context.getBean(RestTemplate.class);


        BookDto newBook = BookDto.builder()
                .serialNumber("dsfd")
                .name("sNEW")
                .author("sfsd")
                .price(9)
                .build();

        newBook.setId((long) 20);
        BookDto savedBook = restTemplate.postForObject(
                "http://localhost:8080/api/books",
                newBook,
                BookDto.class
        );

        savedBook.setPrice(10);
        restTemplate.put(
                "http://localhost:8080/api/books/{id}",
                savedBook,
                savedBook.getId()
        );

        restTemplate.delete(
                "http://localhost:8080/api/books/{id}",
                savedBook.getId()
        );

        BooksDto booksDto = restTemplate.getForObject(
                "http://localhost:8080/api/books",
                BooksDto.class
        );
        System.out.println(booksDto);

        System.out.println("bye ");
    }
}
