package com.ceyentra.spring.security.controller;

import com.ceyentra.spring.security.entity.Student;
import com.ceyentra.spring.security.security.ApplicationUSerPermission;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/student")
public class StudentManagementController {

    private static final List<Student> students = Arrays.asList(
            new Student(1,"Achira De silva"),
            new Student(2,"Akila De silva"),
            new Student(3,"Chathuri De silva")
    );
    @GetMapping
    public static List<Student> getStudents() {
        System.out.println("enum" + ApplicationUSerPermission.COURSE_READ.name());
        System.out.println("enum2" + ApplicationUSerPermission.COURSE_READ.getPermission());
        return students;
    }
     @PostMapping
     public void register(@RequestBody Student student){
         System.out.println("registerd..");
     }

     @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id){
        System.out.println("deleted..");
    }
    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable Integer id ,@RequestBody Student student){
        System.out.println("updated..");
    }
}
