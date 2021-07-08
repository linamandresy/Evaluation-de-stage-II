import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(
    private http:HttpClient,
    private router:Router
  ) { }

  login(logins:string,passwords:string):Observable<any>{
    const data = new FormData();
    data.append('logins',logins);
    data.append('passwords',passwords);
    return this.http.post(base_url+"utilisateur/login",data);
  }
  checkToken():Observable<any>{
    const opt={
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    }
    return this.http.get(base_url+"utilisateur",opt);
  }
}
