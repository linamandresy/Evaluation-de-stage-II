import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-update-categorie',
  templateUrl: './update-categorie.component.html',
  styleUrls: ['./update-categorie.component.scss']
})
export class UpdateCategorieComponent implements OnInit {
  id:any='';
  nom:string='';
  nbhn:any='';
  salaire:any='';
  ind:any='';
  error:string='';
  constructor(
    private route:ActivatedRoute,
    private service:CategorieService,
    private router:Router
  ) { }

  ngOnInit(): void {
    const onSuccess = (res:any)=>{
      if(res.status==200){
        this.nom=res.data.nomCategorie;
        this.nbhn=res.data.nbHeureN;
        this.salaire=res.data.salaireHN;
        this.ind=res.data.indamnite;
      }
      else this.router.navigate(['error',res.data]);
    }
    const onError = (err:any)=>{
      this.router.navigate(['error',err.message]);
    }
    this.route.params.subscribe(params=>{
      this.id=params['id'];
      this.service.getById(this.id).subscribe(onSuccess,onError);
    });
  }

  update():void{
    this.service.update(this.id,this.nom,this.nbhn,this.salaire,this.ind).subscribe(
      (res)=>{
        if(res.status==200) this.router.navigate(['categorie']);
        else this.error=res.data;
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    )
  }
}
