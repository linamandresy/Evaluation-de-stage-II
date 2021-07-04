import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategorieService } from 'src/app/service/categorie.service';

@Component({
  selector: 'app-list-categorie',
  templateUrl: './list-categorie.component.html',
  styleUrls: ['./list-categorie.component.scss']
})
export class ListCategorieComponent implements OnInit {
  categories:any=[]
  constructor(
    private service:CategorieService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.service.getlist().subscribe((res)=>{
      if(res.status==200) this.categories=res.data;
      else this.router.navigate(['error',res.data]);
    },(err)=>{
      this.router.navigate(['error',err.message]);
    });
  }

}
