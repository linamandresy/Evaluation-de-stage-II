import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HsService } from 'src/app/service/hs.service';

@Component({
  selector: 'app-update-hs',
  templateUrl: './update-hs.component.html',
  styleUrls: ['./update-hs.component.scss']
})
export class UpdateHsComponent implements OnInit {
  id:any='';
  nomHS: string = '';
  nbHS: any = '';
  idHSPrec: number = 0;
  heuresups: Array<any> = [];
  pourcentage:any='';
  error:string='';
  constructor(
    private router:Router,
    private route:ActivatedRoute,
    private service:HsService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      this.id=params['id'];
      this.service.findById(this.id).subscribe(
        (res)=>{
          if(res.status==200){
            this.nomHS=res.data.nomHS;
            this.nbHS=res.data.nbHeure;
            this.idHSPrec=res.data.idHSPrec;
            this.pourcentage=res.data.pourcentage;
            console.log(this.idHSPrec)
          }else
            this.router.navigate(['error',res.data])
        },(err)=>{
          this.router.navigate(['error',err.message])
        }
      )
    });
    this.service.getHS().subscribe((res)=>{
      if(res.status==200) {
        const temp=res.data;
        for (let index = 0; index < temp.length; index++) {
          if(temp[index].idHeureSup!=this.id)
            this.heuresups.push(temp[index])
        }
      }
      else this.router.navigate(['error',res.data])
    },(err)=>{
      this.router.navigate(['error',err.message])
    });
  }
  update():void{
    this.service.updateHS(this.id,this.nomHS,this.nbHS,this.idHSPrec,this.pourcentage).subscribe(
      (res)=>{
        if(res.status==200) this.router.navigate(['hs'])
        else this.error=res.data
      },(err)=>{
        this.router.navigate(['error',err.message])
      }
    )    
  }
}
