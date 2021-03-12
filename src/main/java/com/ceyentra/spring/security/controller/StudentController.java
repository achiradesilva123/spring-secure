package com.ceyentra.spring.security.controller;

import com.ceyentra.spring.security.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1,"Achira De silva"),
            new Student(2,"Akila De silva"),
            new Student(3,"Chathuri De silva")
    );

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable Integer id){
        return students.stream().filter( student -> id.equals(student.getStudent_id()))
                .findFirst()
                .orElseThrow( () -> new IllegalStateException("Student "+id +" Does Not Exist"));
    }

}
