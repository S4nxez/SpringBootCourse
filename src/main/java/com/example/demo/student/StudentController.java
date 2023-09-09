package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService stdntServ;

    @Autowired
    public StudentController(StudentService stdntServ) {
        this.stdntServ = stdntServ;
    }

    @GetMapping
    public List<Student> getStudents(){
        return stdntServ.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        stdntServ.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        stdntServ.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        stdntServ.updateStudent(studentId,name,email);
    }
}
