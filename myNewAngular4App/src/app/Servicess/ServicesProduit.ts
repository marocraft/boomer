import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers,Response, ResponseOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import "rxjs/add/operator/map";


@Injectable()
export class ServicelistfilesService {
  private urlf:String="http://localhost:8091";
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  
    errorhandler(error:Response){
      return Observable.throw(error || "SERVERv ERROR");
    }
  constructor( private _httpser:Http ) { }

  
  GetListProduit(){
    return this._httpser.get(this.urlf+"/AllProduit").map((res:Response )=> res.json());
  }













}
