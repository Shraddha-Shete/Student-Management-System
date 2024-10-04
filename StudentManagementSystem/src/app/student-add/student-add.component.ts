import { ChangeDetectionStrategy, Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class StudentAddComponent {
  title = 'StudentManagementSystem';
  student: Student = new Student();
  registrationSuccess: boolean = false;

  constructor(private studentService: StudentService, private route: Router) {}

  register(form: any) {
    if (form.valid) {
      this.studentService.call(this.student).subscribe((res) => {
        console.log(res);
        alert('Student added successfully');
        form.resetForm(); // Reset the form after successful submission
      });
    } else {
      alert('Please fill out the form correctly');
    }
  }
}
