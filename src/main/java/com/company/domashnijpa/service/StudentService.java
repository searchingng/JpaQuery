package com.company.domashnijpa.service;

import com.company.domashnijpa.dto.StudentDTO;
import com.company.domashnijpa.entity.StudentEntity;
import com.company.domashnijpa.enums.Gender;
import com.company.domashnijpa.repository.StudentRepository;
import com.company.domashnijpa.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public StudentDTO save(StudentDTO dto) {
        StudentEntity entity = MapperUtil.DtoToEntity(dto);
        studentRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public String delete(Long id) {
        studentRepository.deleteById(id);
        return "Successfully deleted IF EXISTS";
    }

    public List<StudentDTO> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getById(Long id) {
        return studentRepository.findById(id)
                .map(MapperUtil::EntityToDTO).orElse(null);
    }

    public List<StudentDTO> getByName(String name) {
        return studentRepository.findByName(name)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> getBySurname(String surname) {
        return studentRepository.findBySurname(surname)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> getByLevel(Integer level) {
        return studentRepository.findByLevel(level)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> getByAge(Integer age) {
        return studentRepository.findByAge(age)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> getByGender(Gender gender) {
        return studentRepository.findByGender(gender)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }
}
