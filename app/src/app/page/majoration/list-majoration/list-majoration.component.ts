import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MajorationService } from 'src/app/service/majoration.service';

@Component({
  selector: 'app-list-majoration',
  templateUrl: './list-majoration.component.html',
  styleUrls: ['./list-majoration.component.scss']
})
export class ListMajorationComponent implements OnInit {
  nuit:number=0;
  dimanche:number=0;
  ferie:number=0;
  imp:number=0;
  constructor(
    private service:MajorationService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.service.get().subscribe(
      (res)=>{
        if(res.status==200){
          this.nuit=res.data[0].pourcentage
          this.dimanche=res.data[1].pourcentage
          this.ferie=res.data[2].pourcentage
          this.imp=res.data[4].pourcentage
        }else this.router.navigate(['error',res.data])
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    )
  }
  update():void{
    console.log(this.imp)
    this.service.update(this.nuit,this.dimanche,this.ferie,this.imp);
  }

}
