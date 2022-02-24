package com.company.domashnijpa.dto;

import com.company.domashnijpa.entity.CourseEntity;
import com.company.domashnijpa.entity.StudentEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScmDTO {
    private Long id;

    private Long sid;
    private StudentEntity student;

    private Long cid;
    private CourseEntity course;

    private Integer mark;
    private LocalDateTime createdDate;
}
