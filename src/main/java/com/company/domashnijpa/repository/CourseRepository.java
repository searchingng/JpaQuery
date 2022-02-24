package com.company.domashnijpa.repository;

import com.company.domashnijpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    List<CourseEntity> findByName(String name);

    List<CourseEntity> findByPrice(Long price);

    List<CourseEntity> findByDuration(Integer duration);

}
