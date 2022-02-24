package com.company.domashnijpa.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseDTO {
    private Long id;
    private String name;
    private Long price;
    private Integer duration;
    private LocalDateTime createdDate;
}
