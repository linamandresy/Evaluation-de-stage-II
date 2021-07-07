import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeService } from 'src/app/service/employe.service';
import { FicheHorraireService } from 'src/app/service/fiche-horraire.service';
import { PointageService } from 'src/app/service/pointage.service';

@Component({
  selector: 'app-insert-pointage',
  templateUrl: './insert-pointage.component.html',
  styleUrls: ['./insert-pointage.component.scss']
})
export class InsertPointageComponent implements OnInit {
  employe:any=''
  isSet:boolean =false; 
  ficheHorraire:any=''
  id:any=''
  lundi:any={
    idEmploye:0,
    idJourSemaine:"1",
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  mardi:any={
    idEmploye:0,
    idJourSemaine:2,
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  mercredi:any={
    idEmploye:0,
    idJourSemaine:3,
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  jeudi:any={
    idEmploye:0,
    idJourSemaine:4,
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  vendredi:any={
    idEmploye:0,
    idJourSemaine:5,
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  samedi:any={
    idEmploye:0,
    idJourSemaine:6,
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  dimanche:any={
    idEmploye:0,
    idJourSemaine:7,
    dureeJour:0,
    dureeNuit:0,
    dureeFerier:0
  }
  error:string=''
  constructor(
    private route:ActivatedRoute,
    private se:EmployeService,
    private router:Router,
    private service:PointageService,
    private fs:FicheHorraireService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      this.id=params['idemp'];
      this.lundi.idEmploye=this.id
      this.mardi.idEmploye=this.id
      this.mercredi.idEmploye=this.id
      this.jeudi.idEmploye=this.id
      this.vendredi.idEmploye=this.id
      this.samedi.idEmploye=this.id
      this.dimanche.idEmploye=this.id
      this.se.findById(this.id).subscribe(
        (res)=>{
          if(res.status==200) {
            this.employe=res.data
          }else this.router.navigate(['error',res.data])
        },(err)=>{
          this.router.navigate(['err',err.message])
        }
      )

      this.fs.getFicheById(this.id).subscribe(
        (res)=>{
          console.log(res);
          if(res.status==200){
            this.isSet=true;
            this.ficheHorraire=res.data
            console.log(this.isSet)
            console.log(this.ficheHorraire)
          }
          else this.isSet=false;
        },(err)=>{
          this.router.navigate(['error',err.message])
        }
      )
  
    });
  }
  save():void{    
    this.service.insertPointage(this.lundi,this.mardi,this.mercredi,this.jeudi,this.vendredi,this.samedi,this.dimanche).subscribe(
      (res)=>{
        if(res.status==200) this.router.navigate(['pointage',this.id,'insert'])
        else this.error=res.data;
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    );
  }
}
