import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InsertCategorieComponent } from './page/categorie/insert-categorie/insert-categorie.component';
import { ListCategorieComponent } from './page/categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './page/categorie/update-categorie/update-categorie.component';
import { InsertEmployeComponent } from './page/employe/insert-employe/insert-employe.component';
import { ListEmployeComponent } from './page/employe/list-employe/list-employe.component';
import { UpdateEmployeComponent } from './page/employe/update-employe/update-employe.component';
import { ErrorComponent } from './page/error/error.component';
import { InsertHsComponent } from './page/hs/insert-hs/insert-hs.component';
import { ListHsComponent } from './page/hs/list-hs/list-hs.component';
import { UpdateHsComponent } from './page/hs/update-hs/update-hs.component';
import { LoginComponent } from './page/login/login.component';
import { FichePaieComponent } from './page/paie/fiche-paie/fiche-paie.component';
import { InsertPointageComponent } from './page/pointage/insert-pointage/insert-pointage.component';
import { ListSemaineComponent } from './page/semaine/list-semaine/list-semaine.component';

const routes: Routes = [
  {
    path:'',
    component:ListEmployeComponent
  },{
    path:'login',
    component:LoginComponent
  },{
    path:'insert',
    component:InsertEmployeComponent
  },{
    path:'hs',
    component:ListHsComponent
  },{
    path:'categorie',
    component:ListCategorieComponent
  },{
    path:'semaine',
    component:ListSemaineComponent
  },{
    path:'hs/insert',
    component:InsertHsComponent
  },{
    path:'hs/:id',
    component:UpdateHsComponent
  },{
    path:'paie/:id',
    component:FichePaieComponent
  },{
    path:':id',
    component:UpdateEmployeComponent
  },{
    path:'error/:message',
    component:ErrorComponent
  },{
    path:'categorie/insert',
    component:InsertCategorieComponent
  },{
    path:'categorie/:id',
    component:UpdateCategorieComponent
  },{
    path:'pointage/:idemp/insert',
    component:InsertPointageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
