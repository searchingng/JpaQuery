package com.company.domashnijpa.utils;

import com.company.domashnijpa.dto.CourseDTO;
import com.company.domashnijpa.dto.ScmDTO;
import com.company.domashnijpa.dto.StudentDTO;
import com.company.domashnijpa.entity.CourseEntity;
import com.company.domashnijpa.entity.ScmEntity;
import com.company.domashnijpa.entity.StudentEntity;

import java.time.LocalDateTime;

public class MapperUtil {

    public static StudentDTO EntityToDTO(StudentEntity entity){

        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setLevel(entity.getLevel());
        dto.setGender(entity.getGender());
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }

    public static StudentEntity DtoToEntity(StudentDTO dto){
        dto.setCreatedDate(LocalDateTime.now());

        StudentEntity entity = new StudentEntity();
                entity.setId(dto.getId());
                entity.setName(dto.getName());
                entity.setSurname(dto.getSurname());
                entity.setAge(dto.getAge());
                entity.setLevel(dto.getLevel());
                entity.setGender(dto.getGender());
                entity.setCreatedDate(dto.getCreatedDate());

        return entity;
    }

    public static CourseDTO EntityToDTO(CourseEntity entity){

        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }

    public static CourseEntity DtoToEntity(CourseDTO dto){
        dto.setCreatedDate(LocalDateTime.now());

        CourseEntity entity = new CourseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(dto.getCreatedDate());

        return entity;
    }

    public static ScmDTO EntityToDTO(ScmEntity entity){

        ScmDTO dto = new ScmDTO();
        dto.setId(entity.getId());

//        dto.setStudent(entity.getStudent());//sss
        dto.setSid(entity.getStudent().getId());
//        dto.setCourse(entity.getCourse());//sss
        dto.setCid(entity.getCourse().getId());

        dto.setMark(entity.getMark());
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }

    public static ScmEntity DtoToEntity(ScmDTO dto){
        dto.setCreatedDate(LocalDateTime.now());

        ScmEntity entity = new ScmEntity();
        entity.setId(dto.getId());
        entity.setStudent(dto.getStudent());
        entity.setCourse(dto.getCourse());
        entity.setMark(dto.getMark());
        entity.setCreatedDate(dto.getCreatedDate());

        return entity;
    }

}
