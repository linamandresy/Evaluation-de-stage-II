import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InsertCategorieComponent } from './page/categorie/insert-categorie/insert-categorie.component';
import { ListCategorieComponent } from './page/categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './page/categorie/update-categorie/update-categorie.component';
import { InsertEmployeComponent } from './page/employe/insert-employe/insert-employe.component';
import { ListEmployeComponent } from './page/employe/list-employe/list-employe.component';
import { UpdateEmployeComponent } from './page/employe/update-employe/update-employe.component';
import { ErrorComponent } from './page/error/error.component';
import { LoginComponent } from './page/login/login.component';

const routes: Routes = [
  {
    path:'',
    component:ListEmployeComponent
  },{
    path:'insert',
    component:InsertEmployeComponent
  },{
    path:':id',
    component:UpdateEmployeComponent
  },{
    path:'login',
    component:LoginComponent
  },{
    path:'error/:message',
    component:ErrorComponent
  },{
    path:'categorie',
    component:ListCategorieComponent
  },{
    path:'categorie/insert',
    component:InsertCategorieComponent
  },{
    path:'categorie/:id',
    component:UpdateCategorieComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
