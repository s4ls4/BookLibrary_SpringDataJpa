import { Component, OnInit } from '@angular/core';
import {Book} from '../shared/book.model';
import {BookService} from '../shared/book.service';

@Component({
  selector: 'app-new-book',
  templateUrl: './new-book.component.html',
  styleUrls: ['./new-book.component.css']
})
export class NewBookComponent implements OnInit {
  str = 'Not submitted';
  book: Book = {
    id: 1,
    serialNumber: '255075',
    name: 'name',
    author: 'author',
    price: 120,
  };

  constructor(public bookService: BookService) { }

  ngOnInit() {
  }

  buttonClicked(): void {
    this.str = JSON.stringify(this.book);
    this.bookService.addBook(this.book)
      .subscribe(book => {
          this.book = book;
          this.str = 'Inserted into the database!' + JSON.stringify(this.book);
        });
  }
}
