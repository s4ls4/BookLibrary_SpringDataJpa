import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BooksComponent } from './books/books.component';
import {PrintBookComponent} from './books/print-books/print-books.component';
import {BookService} from './books/shared/book.service';
import { NewBookComponent } from './books/new-book/new-book.component';
import { BookDetailsComponent } from './books/book-details/book-details.component';

@NgModule({
  declarations: [
    AppComponent,
    PrintBookComponent,
    BooksComponent,
    NewBookComponent,
    BookDetailsComponent,
    ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    BookService,
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
