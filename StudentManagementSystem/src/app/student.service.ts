import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from './student';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  baseURL =" http://localhost:8080"
  constructor(private http:HttpClient) { }

  call(student:Student):Observable<Student>{
    console.log("hii service")
    return this.http.post<Student>('http://localhost:8080/save',student);
  }

  listOfStudent():Observable<Student[]>{
    console.log("service")
    return this.http.get<Student[]>('http://localhost:8080/list')
  }

  deleteById(id:number):Observable<any>{
    console.log("delete in service");
    return this.http.delete<any>(`${this.baseURL}/delete/${id}`);
  }

  findById(id:number):Observable<Student>{
    return this.http.get<Student>(`${this.baseURL}/find/${id}`);
  }
  updateStudent(id:number, student:Student):Observable<Student>{
    console.log("hi service")
    return this.http.put<Student>(`${this.baseURL}/update/${id}`,student);
  }

  loginAdmin(email:string, password:string){
    let Body={
      email:email,
      password:password

    }

    return this.http.post<any>(`${this.baseURL}/login`,Body)
  }

  save(admin:Admin):Observable<Admin>{
    console.log(admin)
    return this.http.post<Admin>(`${this.baseURL}/saveAdmin`,admin)
  }
}
