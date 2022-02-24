package com.company.domashnijpa.controller;

import com.company.domashnijpa.dto.CourseDTO;
import com.company.domashnijpa.dto.StudentDTO;
import com.company.domashnijpa.enums.Gender;
import com.company.domashnijpa.service.CourseService;
import com.company.domashnijpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody CourseDTO dto){
        return ResponseEntity.ok(courseService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok(courseService.delete(id));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(courseService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable("name") String name){
        return ResponseEntity.ok(courseService.getByName(name));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity getByPrice(@PathVariable("price") Long price){
        return ResponseEntity.ok(courseService.getByPrice(price));
    }

    @GetMapping("/duration/{duration}")
    public ResponseEntity getByDuration(@PathVariable("duration") Integer duration){
        return ResponseEntity.ok(courseService.getByDuration(duration));
    }

}
