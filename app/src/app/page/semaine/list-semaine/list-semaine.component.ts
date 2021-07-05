import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SemaineService } from 'src/app/service/semaine.service';
declare var $:any;

@Component({
  selector: 'app-list-semaine',
  templateUrl: './list-semaine.component.html',
  styleUrls: ['./list-semaine.component.scss']
})
export class ListSemaineComponent implements OnInit {

  semaine:Array<any>=[]
  constructor(
    private service:SemaineService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.service.getSemaine().subscribe(
      (res)=>{
        if(res.status==200){
          this.semaine=res.data;
          $(function(){
            $("#table").DataTable();
          });  
        }
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    )
  }

}
