package client.ui;


import core.model.Book;
import core.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import web.dto.BookDto;
import web.dto.BooksDto;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


@Component
public class Console {

    @Autowired
    RestTemplate restTemplate;


    private int menuBooks() {
        System.out.println("_________________________________________");
        System.out.println(" ");
        System.out.println("  B O O K   L I B R A R Y / B O O K S");
        System.out.println("_________________________________________");
        System.out.println(" ");
        System.out.println("1. Print all books");
        System.out.println("2. Add a book");
        System.out.println("3. Delete a book");
        System.out.println("4. Update a book");
        System.out.println("0. Exit");

        System.out.println("Enter command: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


    /**
     * Starts the application
     */
    public void miniRunConsole() {


        int cmdBooks = menuBooks();

        while (cmdBooks > 0) {
            if (cmdBooks == 1) {
                this.printAllBooks();
            }
            if (cmdBooks == 2) {
                this.addBook();
            }
            if (cmdBooks == 3) {
                this.deleteBook();
            }
            if (cmdBooks == 4) {
                this.updateBook();
            }
            cmdBooks = menuBooks();
        }
    }


    /**
     * Reads a book from the console
     *
     * @return the book object
     */
    private Book readBook() throws Exception {
        System.out.println("Read book {id, serialNumber, name, author, price}");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        Long id = Long.valueOf(bufferRead.readLine());
        String serialNumber = bufferRead.readLine();
        String name = bufferRead.readLine();
        String author = bufferRead.readLine();
        int price = Integer.parseInt(bufferRead.readLine());

        Book book = new Book(serialNumber, name, author, price);
        return book;
    }

    private void addBook() {

        try {
            Book book = this.readBook();
            BookDto bDto = BookDto.builder()
                    .serialNumber(book.getSerialNumber())
                    .name(book.getName())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .build();

            restTemplate.postForObject("http://localhost:8080/api/books",
                    bDto, BookDto.class);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void deleteBook() {

        System.out.println("Book id: ");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        try {
            Long id = Long.valueOf(bufferRead.readLine());
            restTemplate.delete("http://localhost:8080/api/books/{id}",id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printAllBooks() {

        BooksDto booksDto = restTemplate.getForObject("http://localhost:8080/api/books", BooksDto.class);
        System.out.println(booksDto);
    }

    private void updateBook() {

        try {

            System.out.println("Book id = ");
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            Long id = Long.valueOf(bufferRead.readLine());

            BookDto bDto=restTemplate.getForObject("http://localhost:8080/api/books/{id}",
                    BookDto.class,id);

            System.out.println("Give the new serialNumber: ");
            String serialNumber = bufferRead.readLine();

            System.out.println("Give the new name: ");
            String name = bufferRead.readLine();

            System.out.println("Give the new author: ");
            String author = bufferRead.readLine();

            System.out.println("Give the new price: ");
            int price = Integer.parseInt(bufferRead.readLine());

            bDto.setSerialNumber(serialNumber);
            bDto.setName(name);
            bDto.setAuthor(author);
            bDto.setPrice(price);

            restTemplate.put("http://localhost:8080/api/books{id}",
                    bDto, bDto.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

