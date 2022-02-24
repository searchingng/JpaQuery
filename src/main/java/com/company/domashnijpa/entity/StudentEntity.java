package com.company.domashnijpa.entity;

import com.company.domashnijpa.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Integer level;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDateTime createdDate;

}
