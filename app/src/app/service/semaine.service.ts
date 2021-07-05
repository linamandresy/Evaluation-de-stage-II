import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class SemaineService {

  constructor(
    private http:HttpClient
  ) { }

  newSemaine():Observable<any>{
    const opt = {
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    }
    return this.http.post(base_url+"semaine",null,opt);
  }
  getSemaine():Observable<any>{
    return this.http.get(base_url+"semaine");
  }
}
