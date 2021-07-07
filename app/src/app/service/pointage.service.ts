import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class PointageService {

  constructor(
    private http:HttpClient
  ) { }

  insertPointage(lundi:any,mardi:any,mercredi:any,jeudi:any,vendredi:any,samedi:any,dimanche:any):Observable<any>{
    const opt = {
      headers:{
        Authorization:'Bearer '+sessionStorage.getItem('token')
      }
    }
    const data={
      lundi:lundi,
      mardi:mardi,
      mercredi:mercredi,
      jeudi:jeudi,
      vendredi:vendredi,
      samedi:samedi,
      dimanche:dimanche
    }
    return this.http.post(base_url+"pointage",data,opt);
  }
}
