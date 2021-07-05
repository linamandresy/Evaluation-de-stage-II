import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-insert-categorie',
  templateUrl: './insert-categorie.component.html',
  styleUrls: ['./insert-categorie.component.scss']
})
export class InsertCategorieComponent implements OnInit {
  nom:string='';
  nbhn:any='';
  salaire:any='';
  ind:any='';
  cat:any='';
  constructor(
    private service:CategorieService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }

  save():void{
    this.service.insertCategorie(this.nom,this.nbhn,this.salaire,this.ind).subscribe((res)=>{
      if(res.status==200) this.router.navigate(['categorie']);
      else this.router.navigate(['error',res.data]);
    },(err)=>{
      this.router.navigate(['error',err.message])
    });
  }
}
