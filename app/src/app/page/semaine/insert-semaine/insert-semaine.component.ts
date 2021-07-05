import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SemaineService } from 'src/app/service/semaine.service';

@Component({
  selector: 'insert-semaine',
  templateUrl: './insert-semaine.component.html',
  styleUrls: ['./insert-semaine.component.scss']
})
export class InsertSemaineComponent implements OnInit {

  constructor(
    private service:SemaineService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }

  generate():void{
    this.service.newSemaine().subscribe((res)=>{
      this.router.navigate(['semaine'])
    })
  }
}
