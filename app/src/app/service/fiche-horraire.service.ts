import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class FicheHorraireService {

  constructor(
    private http:HttpClient
  ) { }
  getFicheById(id:number):Observable<any>{
    return this.http.get(base_url+"fichehorraire/"+id);
  }
}
