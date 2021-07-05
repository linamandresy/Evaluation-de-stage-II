import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategorieService } from 'src/app/service/categorie.service';
import { EmployeService } from 'src/app/service/employe.service';

@Component({
  selector: 'app-update-employe',
  templateUrl: './update-employe.component.html',
  styleUrls: ['./update-employe.component.scss']
})
export class UpdateEmployeComponent implements OnInit {
  id:any=''
  mat:string=''
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
    private  service:EmployeService,
    private route:ActivatedRoute
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
    );
    const onSuccess=(res:any)=>{
      if(res.status==200){
        this.id=res.data.idEmploye;
        this.nom=res.data.nom;
        this.prenom=res.data.prenom;
        this.mat=res.data.matricule;
        this.naissance=res.data.naissance;
        this.embauche=res.data.embauche;
        this.fincontrat=res.data.finContrat;
        this.idCategorie=res.data.idCategorie;
      } else this.error=res.data;    
    }
    const onError=(err:any)=>{
      this.router.navigate(['error',err.message]);
    }
    this.route.params.subscribe(params=>{
      this.id=params['id'];
      this.service.findById(this.id).subscribe(onSuccess,onError);
    });
  }
  update():void{
    this.service.updateEmploye(this.id,this.nom,this.prenom,this.mat,this.naissance,this.embauche,this.fincontrat,this.idCategorie).subscribe(
      (res)=>{
        if(res.status==200) this.router.navigate(['']);
        else this.error=res.data;
      },(err)=>{
        this.router.navigate(['error',err.message]);
      }
    );    
  }
}
