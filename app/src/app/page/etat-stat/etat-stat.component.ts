import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EtatStatService } from 'src/app/service/etat-stat.service';
declare var $:any;

@Component({
  selector: 'app-etat-stat',
  templateUrl: './etat-stat.component.html',
  styleUrls: ['./etat-stat.component.scss']
})
export class EtatStatComponent implements OnInit {
  fiche:any=''
  heure:any=''
  constructor(
    private service:EtatStatService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.service.get().subscribe(
      (res)=>{
        console.log(res.data)
        if(res.status==200) {
          this.fiche=res.data;
          this.heure=res.data.fichePaies
          $(function(){
            $("#table").DataTable();
          });  
        }
        else this.router.navigate(['error',res.data])
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    )
  }

}
