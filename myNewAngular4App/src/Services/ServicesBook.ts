import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers,Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import "rxjs/add/operator/map";
import { Book } from '../app/model/book.model';

@Injectable()
export class ServiceBooks {
  private urlf:String="http://localhost:8082";
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});
 
    errorhandler(error:Response){
      return Observable.throw(error || "SERVERv ERROR");
    }
  constructor( private _httpser:Http ) { }

  getAllBooks(){
    return this._httpser.get(this.urlf+"/books").map((res:Response )=> res.json());
  }
  AddBook(book : Book){
   alert("le book a bien ajouté")
    let url = `${this.urlf}/book`;
    return this._httpser.post(url,book).subscribe(res => console.log(res.json()));
  }


}
