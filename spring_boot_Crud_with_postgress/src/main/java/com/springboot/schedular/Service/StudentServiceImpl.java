package com.springboot.schedular.Service;

import com.springboot.schedular.Entity.Student;
import com.springboot.schedular.Exceptions.*;
import com.springboot.schedular.Repository.StudentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired      //internally @Autowired internally performs setter injection
    private StudentRepository studentRepository;

    @SneakyThrows
    @Override
    public ResponseEntity<String> saveStudent(Student student) {
        if(student==null)
        {
            throw new StudentDetailsEmptyException("Provide Student Details to save into database");
        }
        else
        {
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).body("Student Data Saved Successfully");
        }

    }

    @SneakyThrows
    @Override
    public ResponseEntity<List<Student>> getAllStudent() {

        List<Student>  list=studentRepository.findAll();
        if(list.isEmpty())
        {
            throw new DatabaseEmptyException("First Insert Data Into Database because Database is Empty");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }

    }

    @SneakyThrows
    @Override
    public ResponseEntity<Student> getStudentById(Integer studentId) {

         Student student=studentRepository.findById(studentId).get();
         if(student.getStudentId()==null)
         {
             throw new NoSuchIdAvailableInDatabase("Invalid studentId please provide valid id");
         }
         else {
             return ResponseEntity.status(HttpStatus.OK).body(student);
         }
    }

    @SneakyThrows
    @Override
    public ResponseEntity<List<Student>> getStudentByFirstName(String studentFirstName) {

       List<Student> list=studentRepository.findByStudentFirstName(studentFirstName);
       Boolean value=list.stream().anyMatch(student -> student.getStudentFirstName().equals(studentFirstName));

       if(value)
       {
           return ResponseEntity.status(HttpStatus.OK).body(list);
       }
       else
       {
           throw new NoAnyDetailsOfFirstNameException("There is no details found for Student name :"+studentFirstName);
       }

    }

    @SneakyThrows
    @Override
    public ResponseEntity<List<Student>> getStudentByDepartment(String studentDepartment) {

        List<Student> list=studentRepository.getStudentByDepartment(studentDepartment);
        if(list.isEmpty())
        {
            throw new NoSuchDepartmentAvailableException("NO such student releated to "+studentDepartment+" Department in database");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }

    }

    @SneakyThrows
    @Override
    public ResponseEntity<String> deleteStudentDetailsById(Integer studentId) {

       Student student=studentRepository.findById(studentId).get();
       if(student.getStudentId()==null)
       {
           throw new NoSuchIdAvailableInDatabase("The studentId "+studentId+" provided by you is not available in database");
       }
       else
       {
           studentRepository.deleteById(studentId);
           return ResponseEntity.status(HttpStatus.OK).body("Data is deleted successfully");
       }
    }

    @SneakyThrows
    @Override
    public ResponseEntity<String> updateStudentDetails(Integer studentId, Student student) {
       Student student1=studentRepository.findById(studentId).get();
       if(student1.getStudentId()==studentId)
       {
           student.setStudentId(studentId);
           studentRepository.save(student);
           return ResponseEntity.status(HttpStatus.OK).body("Data is updated sucessfully");
       }
       else
       {
           studentRepository.save(student);
           throw new NoSuchIdAvailableInDatabase("The studentId "+studentId+" is not available in database save in database successfully");
       }

    }
}
