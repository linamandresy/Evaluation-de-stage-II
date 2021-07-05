import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class HsService {

  constructor(
    private http:HttpClient
  ) { }

  getHS():Observable<any>{
    return this.http.get(base_url+"heuresup");
  }
  insertHS(nomHS:any,nbHS:any,idHSPrec:any,pourcentage:any):Observable<any>{
    const opt = {
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    };
    const data = new FormData();
    data.append("nomHS",nomHS);
    data.append("nbHeure",nbHS);
    data.append("idHSPrec",idHSPrec);
    data.append("pourcentage",pourcentage);
    return this.http.post(base_url+"heuresup",data,opt);    
  }
  findById(id:any):Observable<any>{
    return this.http.get(base_url+"heuresup/"+id);
  }
  updateHS(id:any,nomHS:string, nbHeure:any, idHSPrec:any, pourcentage:any):Observable<any>{
    const opt = {
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    };
    const data = new FormData();
    data.append("nomHS",nomHS);
    data.append("nbHeure",nbHeure);
    data.append("idHSPrec",idHSPrec);
    data.append("pourcentage",pourcentage);
    return this.http.put(base_url+"heuresup/"+id,data,opt);
  }
}
