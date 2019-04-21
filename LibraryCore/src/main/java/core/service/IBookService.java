package service;

import model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);

    Book updateBook(Long id, Book convertDtoToModel);

    void deleteBook(Long id);
}