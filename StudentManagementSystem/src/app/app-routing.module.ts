import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentAddComponent } from './student-add/student-add.component';
import { StudentListComponent } from './student-list/student-list.component';
import { StudentUpdateComponent } from './student-update/student-update.component';
import { LoginComponent } from './login/login.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:'add', component:StudentAddComponent},
  {path:'findList', component:StudentListComponent},
  {path:'updateStudent/:id', component:StudentUpdateComponent},
  {path: 'signIn', component:SignInComponent},
  {path:'login', component:LoginComponent},
  {path: '', redirectTo:"login", pathMatch:'full'},
  {path:'home', component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
