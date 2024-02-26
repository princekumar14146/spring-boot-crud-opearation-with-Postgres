package com.springboot.schedular.Controller;

import com.springboot.schedular.Entity.Student;
import com.springboot.schedular.Service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    private StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService)
    {
        this.studentService=studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer studentId)
    {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/get1")
    public ResponseEntity<List<Student>>  getStudentByFirstName(@RequestParam("studentFirstName")  String studentFirstName)
    {
        return studentService.getStudentByFirstName(studentFirstName);
    }

    @GetMapping("/get2")
    public ResponseEntity<List<Student>>  getStudentByDepartment(@RequestHeader("studentDepartment") String studentDepartment)
    {
        return studentService.getStudentByDepartment(studentDepartment);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String>  deleteStudentDetailsById(@PathVariable("studentId") Integer studentId)
    {
        return studentService.deleteStudentDetailsById(studentId);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<String> updateStudentDetails(@PathVariable("studentId") Integer studentId, @RequestBody Student student)
    {
        return studentService.updateStudentDetails(studentId, student);
    }


}
