import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BookDetailComponent} from "./books/book-detail/book-detail.component";
import {BooksComponent} from "./books/books.component";
import {BookListComponent} from "./books/book-list/book-list.component";
import {HttpClientModule} from "@angular/common/http";
import {BookService} from "./books/shared/book.service";

@NgModule({
  declarations: [
    AppComponent,
    BookDetailComponent,
    BooksComponent,
    BookListComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
