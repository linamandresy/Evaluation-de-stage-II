import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(
    private http:HttpClient
  ) { }

  login(logins:string,passwords:string):Observable<any>{
    const data = new FormData();
    data.append('logins',logins);
    data.append('passwords',passwords);
    return this.http.post(base_url+"utilisateur/login",data);
  }
}
