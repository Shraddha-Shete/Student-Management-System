import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-update',
  templateUrl: './student-update.component.html',
  styleUrl: './student-update.component.css'
})
export class StudentUpdateComponent {
  student:Student=new Student;
  id!:number;

  constructor(private studenService:StudentService, private router:Router, private route:ActivatedRoute){}

  ngOnInit(){
    this.id=this.route.snapshot.params[('id')];
    console.log("id is : "+this.id);
    this.studenService.findById(this.id).subscribe((res)=>{
      console.log(res);
      this.student=res;
    })
  }

  update(form:any){
    if (form.valid) {
    this.studenService.updateStudent(this.id, this.student).subscribe((res)=>{
      this.loadStudent();
      alert("update successfull")
    })
  } else {
    alert('Please fill out the form correctly');
  }
  }

  loadStudent(){
    this.router.navigate(['findList'])
  }

}
