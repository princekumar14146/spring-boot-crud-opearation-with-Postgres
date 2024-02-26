package com.springboot.schedular.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Pattern(regexp = "^[a-zA-Z]+$" ,message = "The studentFirstName should contains only Alphabets")
    @NotBlank(message = "The studentLastName should not be blank") // in this annotations the states must not be null and also containing non whitespace characters like any character except white spaces,newline etc
    @NotNull(message = "The studentFirstName should not be null") // in this annotations the staes must not be null
    @Column(name = "student_first_name")
    private String studentFirstName;

    @Pattern(regexp = "^[a-zA-Z]+$",message = "The studentLastName should contains only Alphabets")
    @NotNull(message = "The studentLastName should not be null")
    @Column(name = "student_last_name")
    private String studentLastName;

    @NotNull(message = "The studentEmail should not be null")
    @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "Provide valid Email address")
    @Column(name = "student_email")
    private String studentEmail;

    @Pattern(regexp = "^[a-zA-Z]+$",message = "The studentDepartment should contains only Alphabets")
    @NotNull(message = "The studentDepartment Should not be null")
    @Column(name = "student_department")
    private String studentDepartment;




}
