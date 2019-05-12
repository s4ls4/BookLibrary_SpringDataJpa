import { Component, OnInit } from '@angular/core';
import {BookService} from '../shared/book.service';
import {Book} from '../shared/book.model';

@Component({
  selector: 'app-print-books',
  templateUrl: './print-books.component.html',
  styleUrls: ['./print-books.component.css']
})
export class PrintBookComponent implements OnInit {
  books: Array<Book>;
  selectedBook: Book;

  constructor(public bookService: BookService) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks(): void {
    this.bookService.getBooks()
      .subscribe(books => this.books = books);
  }

  removeBook(book): void {
    this.bookService.removeBook(book)
      .subscribe(m => {
          this.books = this.books.filter(bo => bo.id !== book.id);
        });
  }

  onSelect(book): void {
    this.selectedBook = book;
  }

}
