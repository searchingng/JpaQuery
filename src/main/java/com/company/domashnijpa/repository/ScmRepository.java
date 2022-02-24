package com.company.domashnijpa.repository;

import com.company.domashnijpa.entity.CourseEntity;
import com.company.domashnijpa.entity.ScmEntity;
import com.company.domashnijpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScmRepository extends JpaRepository<ScmEntity, Long> {

//    List<ScmEntity> findByStudent(StudentEntity student);

    List<ScmEntity> findByCourse(CourseEntity course);

    List<ScmEntity> findByMark(Integer mark);

    List<ScmEntity> findByStudentAndCreatedDateBetween(StudentEntity student, LocalDateTime from, LocalDateTime to);

    List<ScmEntity> findByStudentOrderByCreatedDateDesc(StudentEntity student);

    List<ScmEntity> findByStudentAndCourseOrderByCreatedDateDesc(StudentEntity student, CourseEntity course);

    Optional<ScmEntity> findTopByStudentOrderByCreatedDateDesc(StudentEntity student);

    Optional<ScmEntity> findTop3ByStudentOrderByMarkDesc(StudentEntity student);

    Optional<ScmEntity> findFirstByStudentOrderByCreatedDateAsc(StudentEntity student);

    Optional<ScmEntity> findFirstByStudentAndCourseOrderByCreatedDateAsc(StudentEntity student, CourseEntity course);


}
