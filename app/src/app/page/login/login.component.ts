import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtilisateurService } from 'src/app/service/utilisateur.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  logins:string='lina';
  passwords:string='123456';

  constructor(
    private service:UtilisateurService,
    private router:Router
  ) { }

  ngOnInit(): void {
  }

  login():void{
    this.service.login(this.logins,this.passwords).subscribe((res)=>{
      if(res.status==200) this.router.navigate(['']);
      else this.router.navigate(['error',res.data]);
    },(err)=>{
      this.router.navigate(['error',err.message]);
    });
  }
}
