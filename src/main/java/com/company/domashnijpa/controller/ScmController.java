package com.company.domashnijpa.controller;

import com.company.domashnijpa.dto.CourseDTO;
import com.company.domashnijpa.dto.ScmDTO;
import com.company.domashnijpa.service.CourseService;
import com.company.domashnijpa.service.ScmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scm")
public class ScmController {

    private final ScmService scmService;

    @Autowired
    public ScmController(ScmService scmService) {
        this.scmService = scmService;
    }

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody ScmDTO dto){
        return ResponseEntity.ok(scmService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id){
        return ResponseEntity.ok(scmService.delete(id));
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(scmService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(scmService.getById(id));
    }

    @GetMapping("/sid/{sid}")
    public ResponseEntity getByStudentId(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(scmService.getByStudentId(sid));
    }

    @GetMapping("/cid/{cid}")
    public ResponseEntity getByCourseId(@PathVariable("cid") Long cid){
        return ResponseEntity.ok(scmService.getByCourseId(cid));
    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity getByMark(@PathVariable("mark") Integer mark){
        return ResponseEntity.ok(scmService.getByMark(mark));
    }

    @GetMapping("/sid/{sid}/{date}")
    public ResponseEntity findByStudentAndCreatedDate(
            @PathVariable("sid") Long sid,
            @PathVariable("date") String date){
        return ResponseEntity.ok(scmService.findByStudentAndDate(sid, date));
    }

    @GetMapping("/sid/{sid}/{from}/{to}")
    public ResponseEntity findByStudentAndCreatedDate(
            @PathVariable("sid") Long sid,
            @PathVariable("from") String from,
            @PathVariable("to") String to){
        return ResponseEntity.ok(scmService.findByStudentAndBetweenDates(sid, from, to));
    }

    @PostMapping("/sidcid")
    public ResponseEntity getBySidAndCid(@RequestBody ScmDTO scmDTO){
        return ResponseEntity.ok(scmService.getBySidAndCid(scmDTO));
    }

    @GetMapping("/sid/{sid}/last")
    public ResponseEntity findLasMarkBySid(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(scmService.findLasMarkBySid(sid));
    }

    @GetMapping("/sid/{sid}/top")
    public ResponseEntity findTop3bySid(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(scmService.findLasMarkBySid(sid));
    }

    @GetMapping("/sid/{sid}/first")
    public ResponseEntity findFirstMarkbySid(@PathVariable("sid") Long sid){
        return ResponseEntity.ok(scmService.findFirstMarkBySid(sid));
    }

    @PostMapping("/sidcid/first")
    public ResponseEntity getFirstBySidAndCid(@RequestBody ScmDTO scmDTO){
        return ResponseEntity.ok(scmService.findFirstMarkBySidAndCid(scmDTO));
    }

}
