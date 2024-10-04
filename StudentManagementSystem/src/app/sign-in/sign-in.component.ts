import { Component } from '@angular/core';
import { Admin } from '../admin';
import { StudentService } from '../student.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent {
 
  admin:Admin=new Admin;
  registrationForm!:NgForm
  constructor(private  studentService:StudentService){}
  get confirmPasswordControl() {
    return this.registrationForm.form.get('confirmPassword');
  }

  register(){
    if (!this.admin.passwordMatch()) {
      console.log('Passwords do not match');
      return;
    }

    this.studentService.save(this.admin).subscribe((res)=>{
      console.log(res);
      alert("Registration Successful")
    },
    (error)=>{
      console.log(error);
      alert("Registration Failed")
    }
  )
  }
}
