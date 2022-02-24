package com.company.domashnijpa.controller;

import com.company.domashnijpa.dto.StudentDTO;
import com.company.domashnijpa.enums.Gender;
import com.company.domashnijpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody StudentDTO dto){
        return ResponseEntity.ok(studentService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.delete(id));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        return ResponseEntity.ok(studentService.getByName(name));
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity getBySurname(@PathVariable("surname") String surname){
        return ResponseEntity.ok(studentService.getBySurname(surname));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity getByLevel(@PathVariable("level") Integer level){
        return ResponseEntity.ok(studentService.getByLevel(level));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity getByAge(@PathVariable("age") Integer age){
        return ResponseEntity.ok(studentService.getByAge(age));
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity getByAge(@PathVariable("gender") Gender gender){
        return ResponseEntity.ok(studentService.getByGender(gender));
    }

}
