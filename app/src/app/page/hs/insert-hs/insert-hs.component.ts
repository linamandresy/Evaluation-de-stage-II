import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HsService } from 'src/app/service/hs.service';

@Component({
  selector: 'app-insert-hs',
  templateUrl: './insert-hs.component.html',
  styleUrls: ['./insert-hs.component.scss']
})
export class InsertHsComponent implements OnInit {
  nomHS: string = '';
  nbHS: any = '';
  idHSPrec: number = 0;
  heuresups: any = [];
  pourcentage:any='';
  error:string='';
  constructor(
    private router: Router,
    private service: HsService
  ) { }

  ngOnInit(): void {
    this.service.getHS().subscribe(
      (res) => {
        if (res.status == 200) this.heuresups = res.data;
        else this.router.navigate(['error', res.data]);
      }, (err) => {
        this.router.navigate(['error', err.message]);
      }
    )
  }
  save(): void {
    this.service.insertHS(this.nomHS,this.nbHS,this.idHSPrec,this.pourcentage).subscribe(
      (res)=>{
        if(res.status==200) this.router.navigate(['hs']);
        else this.error=res.data;
      },(err)=>{
        this.router.navigate(['error',err.message]);
      }
    )
  }
}
