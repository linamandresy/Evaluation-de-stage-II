import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HsService } from 'src/app/service/hs.service';
declare var $:any;
@Component({
  selector: 'app-list-hs',
  templateUrl: './list-hs.component.html',
  styleUrls: ['./list-hs.component.scss']
})
export class ListHsComponent implements OnInit {
  heuresups:any=[];
  constructor(
    private service:HsService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.service.getHS().subscribe(
      (res)=>{
        if(res.status==200) {
          this.heuresups=res.data;
          $(function(){
            $("#table").DataTable();
          });
        }else this.router.navigate(['error',res.data]);
      },(err)=>{
        this.router.navigate(['error',err.message]);
      }
    )
  }

}
