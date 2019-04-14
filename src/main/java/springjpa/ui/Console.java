package springjpa.ui;

import springjpa.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springjpa.service.BookService;
import springjpa.service.IBookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Author: Muradasil Birhan
 */
@Component
public class Console {

    @Autowired
    private IBookService bookService;


    public Console() {

    }


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
                this.addBooks();
            }
            if (cmdBooks == 3) {
                this.deleteBooks();
            }
            if (cmdBooks == 4) {
                this.updateBooks();
            }
            cmdBooks = menuBooks();
        }
    }


    private void printAllBooks() {
        List<Book> books = this.bookService.getAllBooks();
        books.forEach((i) -> System.out.println((i.toString())));
    }


    private void addBooks() {

        try {
            Book book = this.readBook();
            this.bookService.saveBook(book);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    private void deleteBooks() {

        System.out.println("Book id: ");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        try {
            Long id = Long.valueOf(bufferRead.readLine());
            this.bookService.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateBooks() {

        try {
            Book book = this.readBook();
            this.bookService.update(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        book.setId(id);
        return book;
    }
}

