import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Book} from '../shared/book.model';
import {BookService} from '../shared/book.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  book: Book;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService
  ) { }

  ngOnInit() {
    this.getBook();
  }

  getBook(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.bookService.getBook(id)
      .subscribe(bo => this.book = bo);
  }

  buttonClicked(): void {
    this.bookService.updateBook(this.book)
      .subscribe(bo => this.book = bo);
  }

}
