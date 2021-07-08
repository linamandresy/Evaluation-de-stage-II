import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UtilisateurService } from './utilisateur.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private userService: UtilisateurService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree{
    return new Observable(observer=>{
      this.userService.checkToken().subscribe(
        (res)=>{
          if(res.status==200) observer.next(true)
          else {
            this.router.navigate(['login'])
            observer.next(false);
          }
          observer.complete();
        },(err)=>{
          this.router.navigate(['login'])
          observer.next(false);
          observer.complete();
        }
      )
    })
  }
}
