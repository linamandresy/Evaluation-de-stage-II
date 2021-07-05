import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategorieService } from 'src/app/service/categorie.service';
import { EmployeService } from 'src/app/service/employe.service';

@Component({
  selector: 'app-insert-employe',
  templateUrl: './insert-employe.component.html',
  styleUrls: ['./insert-employe.component.scss']
})
export class InsertEmployeComponent implements OnInit {
  nom:string=''
  prenom:string=''
  naissance:any=''
  embauche:any=''
  fincontrat:any=''
  idCategorie:any=''
  categories:any=[];
  error:string='';
  constructor(
    private cateServ:CategorieService,
    private router:Router,
    private  service:EmployeService
  ) { }

  ngOnInit(): void {
    this.cateServ.getlist().subscribe(
      (res)=>{
        if(res.status==200){
          this.categories=res.data;
        }else{
          this.router.navigate(['error',res.data]);
        }
      },(err)=>{
        this.router.navigate(['error',err.message]);
      }
    )
  }

  save():void{
    this.service.insertEmploye(this.nom,this.prenom,this.naissance,this.embauche,this.fincontrat,this.idCategorie).subscribe(
      (res)=>{
        if(res.status==200){
          this.router.navigate(['']);
        }else{
          this.error=res.data;
        }
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    );
  }
}
