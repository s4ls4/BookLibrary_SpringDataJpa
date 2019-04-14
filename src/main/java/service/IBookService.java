package service;

import domain.Book;

import java.util.List;
import java.util.Set;

public interface IBookService {
    List<Book> getAllBooks();
    void saveBook(Book book);

    void update(Book book);

    void delete(Long id);
}
