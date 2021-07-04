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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ErrorComponent,
    ListEmployeComponent,
    InsertCategorieComponent,
    ListCategorieComponent,
    UpdateCategorieComponent
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
