import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './page/login/login.component';
import { ErrorComponent } from './page/error/error.component';
import { ListEmployeComponent } from './page/employe/list-employe/list-employe.component';
import { InsertCategorieComponent } from './page/categorie/insert-categorie/insert-categorie.component';
import { ListCategorieComponent } from './page/categorie/list-categorie/list-categorie.component';
import { UpdateCategorieComponent } from './page/categorie/update-categorie/update-categorie.component';
import { InsertEmployeComponent } from './page/employe/insert-employe/insert-employe.component';
import { UpdateEmployeComponent } from './page/employe/update-employe/update-employe.component';
import { InsertHsComponent } from './page/hs/insert-hs/insert-hs.component';
import { ListHsComponent } from './page/hs/list-hs/list-hs.component';
import { UpdateHsComponent } from './page/hs/update-hs/update-hs.component';
import { HeadNavComponent } from './component/head-nav/head-nav.component';
import { InsertSemaineComponent } from './page/semaine/insert-semaine/insert-semaine.component';
import { ListSemaineComponent } from './page/semaine/list-semaine/list-semaine.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ErrorComponent,
    ListEmployeComponent,
    InsertCategorieComponent,
    ListCategorieComponent,
    UpdateCategorieComponent,
    InsertEmployeComponent,
    UpdateEmployeComponent,
    InsertHsComponent,
    ListHsComponent,
    UpdateHsComponent,
    HeadNavComponent,
    InsertSemaineComponent,
    ListSemaineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
