package service;

import domain.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    void saveBook(Book book);

    void update(Book book);

    void delete(Long id);
}
