import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListEmployeComponent } from './page/employe/list-employe/list-employe.component';
import { ErrorComponent } from './page/error/error.component';
import { LoginComponent } from './page/login/login.component';

const routes: Routes = [
  {
    path:'',
    component:ListEmployeComponent
  },{
    path:'login',
    component:LoginComponent
  },{
    path:'error',
    component:ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
