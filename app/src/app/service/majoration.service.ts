import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { base_url } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class MajorationService {

  constructor(
    private http:HttpClient
  ) { }
  get():Observable<any>{
    return this.http.get(base_url+"majoration");
  }
  update(nuit:any,dimanche:any,ferier:any,impot:any) : void{
    let data = new FormData();
    data.append("nomMaj","Nuit")
    data.append("pourcentage",nuit)
    this.http.put(base_url+"majoration/1",data).subscribe((res)=>{
      

    let data1 = new FormData();
    data1.append("nomMaj","Dimanche")
    data1.append("pourcentage",dimanche)
    this.http.put(base_url+"majoration/2",data1).subscribe((res)=>{
      
    let data2 = new FormData();
    data2.append("nomMaj","Ferier")
    data2.append("pourcentage",ferier)
    this.http.put(base_url+"majoration/3",data2).subscribe((res)=>{

      let data3 = new FormData();
      data3.append("nomMaj","Impot")
      data3.append("pourcentage",impot)
      console.log(impot)
      this.http.put(base_url+"majoration/5",data3).subscribe((res)=>{
        // window.location.reload();
      });
    });

    });
    });

  }
}
