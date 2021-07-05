import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(
    private http:HttpClient
  ) { }

  insertCategorie(nom:string,nbhn:any,salaire:any,ind:any):Observable<any>{
    const data = new FormData();
    data.append("nomCategorie",nom);
    data.append("nbHeureN",nbhn);
    data.append("salaireHN",salaire);
    data.append("indamnite",ind);
    const opt = {
      headers:{
        'Authorization':'Bearer '+sessionStorage.getItem("token")
      }
    }
    return this.http.post(base_url+"categorie",data,opt);
  }
  getlist():Observable<any>{
    return this.http.get(base_url+"categorie");
  }
  getById(id:any):Observable<any>{
    return this.http.get(base_url+"categorie/"+id);
  }
  update(id:any ,nomCategorie:any,nbHeureN:any,salaireHN:any, indamnite:any):Observable<any>{
    const data = new FormData();
    data.append("nomCategorie",nomCategorie);
    data.append("nbHeureN",nbHeureN);
    data.append("salaireHN",salaireHN);
    data.append("salaireHN",salaireHN);
    data.append("indamnite",indamnite);
    const opt = {
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    }
    return this.http.put(base_url+"categorie/"+id,data,opt);
  }
}
