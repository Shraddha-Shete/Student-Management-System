import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email!:string;
  password!:string;

  constructor(private studentService:StudentService, private router:Router){}

  login(){
    console.log(this.email, this.password)
   this.studentService.loginAdmin(this.email, this.password).subscribe((res)=>{
    if (res.message == "Email not exits")
      {
        alert("Email not exits");
      }
      else if(res.message == "Login Success"){
       
          this.router.navigate(['home']);
        }
      
      else
      {
        alert("Incorrect Password ");
      }

   })
  }

}
