import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeService } from 'src/app/service/employe.service';

@Component({
  selector: 'app-list-employe',
  templateUrl: './list-employe.component.html',
  styleUrls: ['./list-employe.component.scss']
})
export class ListEmployeComponent implements OnInit {
  employes:any=[];
  constructor(
    private service:EmployeService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.service.getEmploye().subscribe((res)=>{
      if(res.status==200) this.employes=res.data;
      else this.router.navigate(['error',res.data]);
    },(err)=>{
      this.router.navigate(['error',err.message]);
    });
  }

}
