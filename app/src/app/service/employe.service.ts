import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  constructor(
    private http:HttpClient
  ) { }

  getEmploye():Observable<any>{
    return this.http.get(base_url+"employe");
  }
}
