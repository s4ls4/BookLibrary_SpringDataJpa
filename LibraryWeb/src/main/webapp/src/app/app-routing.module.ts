
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BooksComponent} from './books/books.component';
import {NewBookComponent} from './books/new-book/new-book.component';
import {BookDetailsComponent} from './books/book-details/book-details.component';

const routes: Routes = [
  { path: 'books', component: BooksComponent },
  { path: 'books/new', component: NewBookComponent },
  { path: 'books/details/:id', component: BookDetailsComponent},
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
