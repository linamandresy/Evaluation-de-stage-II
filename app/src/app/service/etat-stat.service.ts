import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class EtatStatService {

  constructor(
    private http:HttpClient
  ) { }
  get():Observable<any>{
    return this.http.get(base_url+"statistique")
  }
}
