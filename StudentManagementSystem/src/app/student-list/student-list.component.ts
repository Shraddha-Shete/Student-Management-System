import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
  
})
export class StudentListComponent {

  constructor(private studenService:StudentService, private route:Router){}
  student!:Student[];
  
  ngOnInit(){
    this.getList();
  }
  getList(){
    console.log("hello form getlist");
    this.studenService.listOfStudent().subscribe((res)=>{
      this.student=res;
      console.log(res);

    })
  }
  delete(id:number){
    console.log("delete");
    this.studenService.deleteById(id).subscribe((res)=>{
      alert("deleted");
      this.getList();
    })
  }
  update(id:number){
    this.route.navigate(['updateStudent', id]);
  }
  

}
