package springjpa.service;

import springjpa.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springjpa.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements IBookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);


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
    public void saveBook(Book book) {
        log.trace("saveBook: book={}", book);

        bookRepository.save(book);

        log.trace("saveBook --- method finished");
    }

    @Override
    @Transactional
    public void update(Book book) {
        log.trace("update: book={}", book);

        bookRepository.findById(book.getId())
                .ifPresent(book1 -> {
                    book1.setSerialNumber(book.getSerialNumber());
                    book1.setName(book.getName());
                    book1.setAuthor(book.getAuthor());
                    book1.setPrice(book.getPrice());
                    log.debug("update --- book updated? --- " +
                            "book={}", book1);
                });

        log.trace("update --- method finished");
    }

    @Override
    public void delete(Long id) {
        log.trace("delete: id={}", id);

        bookRepository.deleteById(id);

        log.trace("delete --- method finished");
    }
}

