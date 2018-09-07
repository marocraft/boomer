import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ServiceBooks } from '../../Services/ServicesBook';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books=[]
  constructor(  private servicesbooks: ServiceBooks, private arouter:Router) { }

  ngOnInit() {
     this.servicesbooks.getAllBooks().subscribe((data)=> {
      console.log(data);                  
      this.books=data
    },(error)=>{console.log(error);
    }
  );
  }

 

}
