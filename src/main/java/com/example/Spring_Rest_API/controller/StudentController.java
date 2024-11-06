package com.example.Spring_Rest_API.controller;
import com.example.Spring_Rest_API.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
    Student student=new Student(1,"Abhilasha","Koka");
    return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudentList(){
     List<Student> listStudent=new ArrayList<>();
     listStudent.add(new Student(1,"Abhilasha","Koka"));
     listStudent.add(new Student(2,"zasdd","wrew"));
     listStudent.add(new Student(3,"jhkhjk","bnbm"));
     return new ResponseEntity<>(listStudent,HttpStatus.OK);
    }
 //http://localhost:8080/students/1
    @GetMapping("students/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id){
        Student student=new Student(id,"Abhilasha","Koka");
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

//http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam("id") int id){
        Student student=new Student(id,"Abhilasha","Koka");
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //http://localhost:8080/students
    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //http://localhost:8080/1/students
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent( @RequestBody Student student,@PathVariable  int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

@DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable  int id){
        return new ResponseEntity<>("Student is deleted!!!", HttpStatus.OK);

    }
}
