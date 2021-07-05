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
  insertEmploye(nom:any, prenom:any, naissance:any, embauche:any,finContrat:any,idCategorie:any):Observable<any>{
    const opt={
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    };
    const data=new FormData();
    data.append("nom",nom);
    data.append("prenom",prenom);
    data.append("naissance",naissance);
    data.append("embauche",embauche);
    data.append("finContrat",finContrat);
    data.append("idCategorie",idCategorie);
    console.log(base_url+"categorie")
    return this.http.post(base_url+"employe",data,opt);
  }
  findById(id:any):Observable<any>{
    return this.http.get(base_url+"employe/"+id);
  }
  updateEmploye(id:any,nom:string,prenom:string,matricule:string, naissance:any, embauche:any,finContrat:any, idCategorie:any):Observable<any>{
    const opt = {
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    };
    const data = new FormData();
    data.append("nom",nom);
    data.append("prenom",prenom);
    data.append("matricule",matricule);
    data.append("naissance",naissance);
    data.append("embauche",embauche);
    data.append("finContrat",finContrat);
    data.append("idCategorie",idCategorie);
    return this.http.put(base_url+"employe/"+id,data,opt);
  }
}
