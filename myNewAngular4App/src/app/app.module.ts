import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule ,Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { BookComponent } from './book/book.component';
import { ServiceBooks } from '../Services/ServicesBook';
import { AddBookComponent } from './add-book/add-book.component';

const appRouts : Routes =  [
  
  { path : 'books' , component :  BookComponent },
  { path : 'addbook' , component :  AddBookComponent },

];


@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    AddBookComponent
  ],

  imports: [
    BrowserModule, FormsModule,HttpModule, RouterModule.forRoot(appRouts)
  ],
  providers: [ServiceBooks],
  bootstrap: [AppComponent]
})
export class AppModule { }
