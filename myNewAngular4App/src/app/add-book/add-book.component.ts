import { Component, OnInit } from '@angular/core';
import { ServiceBooks } from '../../Services/ServicesBook';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private servicesbooks: ServiceBooks, private arouter:Router) { }

  ngOnInit() {
    
  }

  onClickSubmit(data){
    this.servicesbooks.AddBook(data);
  }

}
