package com.springboot.schedular.Service;

import com.springboot.schedular.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public ResponseEntity<String> saveStudent(Student student);
    public ResponseEntity<List<Student>> getAllStudent();
    public ResponseEntity<Student> getStudentById(Integer studentId);

    public ResponseEntity<List<Student>>  getStudentByFirstName(String studentFirstName);

    public ResponseEntity<List<Student>>   getStudentByDepartment(String studentDepartment);

    public ResponseEntity<String>  deleteStudentDetailsById(Integer studentId);

    public ResponseEntity<String> updateStudentDetails(Integer studentId,Student student);

}
