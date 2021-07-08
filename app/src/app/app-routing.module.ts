import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InsertCategorieComponent } from './page/categorie/insert-categorie/insert-categorie.component';
import { ListCategorieComponent } from './page/categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './page/categorie/update-categorie/update-categorie.component';
import { InsertEmployeComponent } from './page/employe/insert-employe/insert-employe.component';
import { ListEmployeComponent } from './page/employe/list-employe/list-employe.component';
import { UpdateEmployeComponent } from './page/employe/update-employe/update-employe.component';
import { ErrorComponent } from './page/error/error.component';
import { EtatStatComponent } from './page/etat-stat/etat-stat.component';
import { InsertHsComponent } from './page/hs/insert-hs/insert-hs.component';
import { ListHsComponent } from './page/hs/list-hs/list-hs.component';
import { UpdateHsComponent } from './page/hs/update-hs/update-hs.component';
import { LoginComponent } from './page/login/login.component';
import { ListMajorationComponent } from './page/majoration/list-majoration/list-majoration.component';
import { FichePaieComponent } from './page/paie/fiche-paie/fiche-paie.component';
import { InsertPointageComponent } from './page/pointage/insert-pointage/insert-pointage.component';
import { ListSemaineComponent } from './page/semaine/list-semaine/list-semaine.component';
import { AuthGuardService } from './service/auth-guard.service';

const routes: Routes = [
  {
    path:'',
    component:ListEmployeComponent,
    canActivate:[AuthGuardService]
  },{
    path:'login',
    component:LoginComponent
  },{
    path:'insert',
    component:InsertEmployeComponent,
    canActivate:[AuthGuardService]
  },{
    path:'stat',
    component:EtatStatComponent,
    canActivate:[AuthGuardService]
  },{
    path:'config',
    component:ListMajorationComponent,
    canActivate:[AuthGuardService]
  },{
    path:'hs',
    component:ListHsComponent,
    canActivate:[AuthGuardService]
  },{
    path:'categorie',
    component:ListCategorieComponent,
    canActivate:[AuthGuardService]
  },{
    path:'semaine',
    component:ListSemaineComponent,
    canActivate:[AuthGuardService]
  },{
    path:'hs/insert',
    component:InsertHsComponent,
    canActivate:[AuthGuardService]
  },{
    path:'hs/:id',
    component:UpdateHsComponent,
    canActivate:[AuthGuardService]
  },{
    path:'paie/:id',
    component:FichePaieComponent,
    canActivate:[AuthGuardService]
  },{
    path:':id',
    component:UpdateEmployeComponent,
    canActivate:[AuthGuardService]
  },{
    path:'error/:message',
    component:ErrorComponent
  },{
    path:'categorie/insert',
    component:InsertCategorieComponent,
    canActivate:[AuthGuardService]
  },{
    path:'categorie/:id',
    component:UpdateCategorieComponent,
    canActivate:[AuthGuardService]
  },{
    path:'pointage/:idemp/insert',
    component:InsertPointageComponent,
    canActivate:[AuthGuardService]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
