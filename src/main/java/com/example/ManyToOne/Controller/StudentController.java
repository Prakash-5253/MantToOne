package com.example.ManyToOne.Controller;

import com.example.ManyToOne.Entity.Department;
import com.example.ManyToOne.Entity.Student;
import com.example.ManyToOne.Repository.DeptRepository;
import com.example.ManyToOne.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DeptRepository deptRepository;
   // @Autowired
    private List<Student> student;

    @PostMapping("/addDetail")
    public String addInfo(@RequestBody Department department){
        deptRepository.save(department);
        return  "posted Successfully";
    }


    @DeleteMapping("/deleteMapping/{deptId}")
    public String deleteInfo(@PathVariable ("deptId") String deptId){
        deptRepository.deleteById(deptId);
        return "Mission Fail";
    }
    @PutMapping("/updateInfo/{deptId}")
    public Student addStudent(@PathVariable("deptId") String deptId,@RequestBody Student student){
        Department dep=deptRepository.getById(deptId);
        Student std=new Student();
        std.setDepartment(dep);
       std.setStudentName(student.getStudentName());
       std.setAge(student.getAge());
       return studentRepository.save(std);
    }
    }


