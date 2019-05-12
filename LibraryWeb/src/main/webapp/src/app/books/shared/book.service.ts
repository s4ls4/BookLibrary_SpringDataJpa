import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Book} from './book.model';
import {Observable} from "rxjs";

@Injectable()
export class BookService {
  path = 'http://localhost:8080/api/books';

  constructor(public httpClient: HttpClient) { }

  getBook(bookId): Observable<Book> {
    console.log('getBook() enter ' + bookId);
    const x = this.path + '/' + bookId;
    console.log('getBook() path ' + x);
    const a = this.httpClient.get<Book>(x);
    console.log('getBook() exit ' + a);
    return a;
  }

  getBooks(): Observable<Array<Book>> {
    console.log('getBooks() enter ');
    const a = this.httpClient.get<Array<Book>>(this.path);
    console.log('getBooks() exit ' + a);
    return a;
  }

  addBook(book): Observable<Book> {
    console.log('addBook entered' + book);
    const a = this.httpClient.post<Book>(this.path, book);
    console.log('addBook exit' + a);
    return a;
  }

  removeBook(book): Observable<Book> {
    console.log('removeBook enter ' + book);
    const x = this.path + '/' + book.id;
    const result = this.httpClient.delete<Book>(x);
    console.log('removeBook exit ' + x);
    return result;
  }

  updateBook(book): Observable<Book> {
    console.log('updateBook entered' + book);
    const x = this.path + '/' + book.id;
    const a = this.httpClient.put<Book>(x, book);
    console.log('updateBook exit' + a);
    return a;
  }

}
