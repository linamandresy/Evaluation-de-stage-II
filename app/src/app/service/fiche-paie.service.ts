import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class FichePaieService {

  constructor(
    private http:HttpClient
  ) { }
  findById(id:number):Observable<any>{
    return this.http.get(base_url+"fichepaie/"+id);
  }
}
