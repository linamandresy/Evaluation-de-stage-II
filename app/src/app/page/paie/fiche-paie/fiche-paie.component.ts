import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FichePaieService } from 'src/app/service/fiche-paie.service';
import { base_url } from 'src/environments/environment.prod';

@Component({
  selector: 'app-fiche-paie',
  templateUrl: './fiche-paie.component.html',
  styleUrls: ['./fiche-paie.component.scss']
})
export class FichePaieComponent implements OnInit {
  id:number=0;
  fiche:any=''
  constructor(
    private route:ActivatedRoute,
    private service:FichePaieService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params=>{
      this.id=params['id'];
      this.service.findById(this.id).subscribe(
        (res)=>{
          console.log(res.data)
          if(res.status==200) this.fiche=res.data;
          else this.router.navigate(['error',res.data]) 
        },(err)=>{
          this.router.navigate(['error',err.message])
        }
      )
    });
  }

  generatePDF():void{
    console.log("hello");
    window.open(base_url+"fichepaie/pdf/"+this.id);
  }
}
