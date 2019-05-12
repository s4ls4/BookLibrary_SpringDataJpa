import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Book} from "./book.model";

import {Observable} from "rxjs";
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import {map} from "rxjs/operators";


@Injectable()
export class BookService {
  private booksUrl = 'http://localhost:8080/api/books';

  constructor(private httpClient: HttpClient) {
  }

  getBooks(): Observable<Book[]> {
    return this.httpClient
      .get<Array<Book>>(this.booksUrl);
  }

  getBook(id: number): Observable<Book> {
    return this.getBooks()
      .pipe(map(books => books.find(book => book.id === id)));
  }

  update(book): Observable<Book> {
    const url = `${this.booksUrl}/${book.id}`;
    return this.httpClient
      .put<Book>(url, book);
  }

}
