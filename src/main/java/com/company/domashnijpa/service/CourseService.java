package com.company.domashnijpa.service;

import com.company.domashnijpa.dto.CourseDTO;
import com.company.domashnijpa.dto.StudentDTO;
import com.company.domashnijpa.entity.CourseEntity;
import com.company.domashnijpa.enums.Gender;
import com.company.domashnijpa.repository.CourseRepository;
import com.company.domashnijpa.repository.StudentRepository;
import com.company.domashnijpa.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public CourseDTO save(CourseDTO dto) {
        CourseEntity entity = MapperUtil.DtoToEntity(dto);
        courseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public String delete(Long id) {
        courseRepository.deleteById(id);
        return "Successfully deleted IF EXISTS";
    }

    public List<CourseDTO> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO getById(Long id) {
        return courseRepository.findById(id)
                .map(MapperUtil::EntityToDTO).orElse(null);
    }

    public List<CourseDTO> getByName(String name) {
        return courseRepository.findByName(name)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getByPrice(Long price) {
        return courseRepository.findByPrice(price)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getByDuration(Integer duration) {
        return courseRepository.findByDuration(duration)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

}
