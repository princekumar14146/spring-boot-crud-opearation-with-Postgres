package com.springboot.schedular.Repository;

import com.springboot.schedular.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByStudentFirstName(String studentFirstName);

    @Query(value = "select * from student where student_department=:n", nativeQuery = true)
    public List<Student> getStudentByDepartment(@Param("n") String studentDepartment);


}
