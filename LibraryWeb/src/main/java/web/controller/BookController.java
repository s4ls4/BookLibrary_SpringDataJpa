package web.controller;

import core.model.Book;
import core.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web.converter.BookConverter;
import web.dto.BookDto;
import web.dto.BooksDto;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    private static final Logger log =
            LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookConverter bookConverter;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    BooksDto getAllBooks() {
        log.trace("getAllBooks --- method entered");

        List<Book> books = bookService.getAllBooks();
        Set<BookDto> dtos = bookConverter.convertModelsToDtos(books);
        BooksDto result = new BooksDto(dtos);

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    StudentDto saveStudent(@RequestBody StudentDto dto) {
        log.trace("saveStudent: dto={}", dto);

        Student saved = this.studentService.saveStudent(
                studentConverter.convertDtoToModel(dto)
        );
        StudentDto result = studentConverter.convertModelToDto(saved);

        log.trace("saveStudent: result={}", result);

        return result;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    StudentDto updateStudent(@PathVariable Long id,
                             @RequestBody StudentDto dto) {
        log.trace("updateStudent: id={},dto={}", id, dto);

        Student update = studentService.updateStudent(
                id,
                studentConverter.convertDtoToModel(dto));
        StudentDto result = studentConverter.convertModelToDto(update);

        return result;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        log.trace("deleteStudent: id={}", id);

        studentService.deleteStudent(id);

        log.trace("deleteStudent --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}