package service;

import model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BookRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements IBookService {
    private static final Logger log =
            LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        log.trace("getAllBooks --- method entered");

        List<Book> result = bookRepository.findAll();

        log.trace("getAllBooks: result={}", result);

        return result;
    }

    @Override
    public Book saveBook(Book book) {
        log.trace("-----saveBook------ book={}", book);

        Book savedBook = this.bookRepository.save(book);

        log.trace("saveBook: result={}", savedBook);

        return savedBook;
    }

    @Override
    @Transactional
    public Book updateBook(Long id, Book book) {
        log.trace("updateBook: id={},book={}", id, book);

        Optional<Book> optionalBook = bookRepository.findById(id);
        Book result = optionalBook.orElse(book);
        result.setSerialNumber(book.getSerialNumber());
        result.setName(book.getName());
        result.setAuthor(book.getAuthor());
        result.setPrice(book.getPrice());

        log.trace("updateBook: result={}", result);

        return result;
    }

    @Override
    public void deleteBook(Long id) {
        log.trace("deleteBook: id={}", id);

        bookRepository.deleteById(id);

        log.trace("deleteBook --- method finished");
    }
}