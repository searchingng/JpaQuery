package com.company.domashnijpa.service;

import com.company.domashnijpa.dto.ScmDTO;
import com.company.domashnijpa.entity.CourseEntity;
import com.company.domashnijpa.entity.ScmEntity;
import com.company.domashnijpa.entity.StudentEntity;
import com.company.domashnijpa.repository.CourseRepository;
import com.company.domashnijpa.repository.ScmRepository;
import com.company.domashnijpa.repository.StudentRepository;
import com.company.domashnijpa.utils.MapperUtil;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScmService {

    @Autowired
    private ScmRepository scmRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public ScmDTO save(ScmDTO dto) {
        ScmEntity entity = MapperUtil.DtoToEntity(dto);
        entity.setStudent(studentRepository.findById(dto.getSid()).orElse(null));
        entity.setCourse(courseRepository.findById(dto.getCid()).orElse(null));
        scmRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public String delete(Long id) {
        scmRepository.deleteById(id);
        return "Successfully deleted IF EXISTS";
    }

    public List<ScmDTO> getAll() {
        return scmRepository.findAll()
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public ScmDTO getById(Long id) {
        return scmRepository.findById(id)
                .map(MapperUtil::EntityToDTO).orElse(null);
    }

    public List<ScmDTO> getByStudentId(Long sid) {
        Optional<StudentEntity> student = studentRepository.findById(sid);

        if (student.isPresent()){
            return scmRepository.findByStudentOrderByCreatedDateDesc(student.get())
                    .stream()
                    .map(MapperUtil::EntityToDTO)
                    .collect(Collectors.toList());
        }

        return new LinkedList<ScmDTO>();
    }

    public List<ScmDTO> getByCourseId(Long cid) {
        Optional<CourseEntity> course = courseRepository.findById(cid);

        return course.map(courseEntity -> scmRepository.findByCourse(courseEntity)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList())).orElseGet(LinkedList::new);

    }

    public List<ScmDTO> getByMark(Integer mark) {
        return scmRepository.findByMark(mark)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ScmDTO> findByStudentAndDate(Long sid, String stringDate){
        Optional<StudentEntity> student = studentRepository.findById(sid);
        LocalDateTime date = LocalDateTime
                .parse(stringDate + "00", DateTimeFormatter.ofPattern("ddMMyyyyHH"));

        return student
                .map(studentEntity -> scmRepository
                        .findByStudentAndCreatedDateBetween(studentEntity, date, date.plusDays(1))
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList())).orElseGet(LinkedList::new);

    }

    public List<ScmDTO> findByStudentAndBetweenDates(Long sid, String from, String to){
        Optional<StudentEntity> student = studentRepository.findById(sid);
        LocalDateTime fromDate = LocalDateTime
                .parse(from + "00", DateTimeFormatter.ofPattern("ddMMyyyyHH"));

        LocalDateTime toDate = LocalDateTime
                .parse(to + "00", DateTimeFormatter.ofPattern("ddMMyyyyHH")).plusDays(1);

        return student
                .map(studentEntity -> scmRepository
                        .findByStudentAndCreatedDateBetween(studentEntity, fromDate, toDate)
                .stream()
                .map(MapperUtil::EntityToDTO)
                .collect(Collectors.toList())).orElseGet(LinkedList::new);

    }

    public List<ScmDTO> getBySidAndCid(ScmDTO dto){
        Optional<StudentEntity> student = studentRepository.findById(dto.getSid());
        Optional<CourseEntity> course = courseRepository.findById(dto.getCid());

        if (student.isPresent() && course.isPresent()){
            return scmRepository
                    .findByStudentAndCourseOrderByCreatedDateDesc(student.get(), course.get())
                    .stream()
                    .map(MapperUtil::EntityToDTO)
                    .collect(Collectors.toList());
        }

        return new LinkedList<ScmDTO>();
    }

    public ScmDTO findLasMarkBySid(Long sid){
        Optional<StudentEntity> student = studentRepository.findById(sid);

        return student.map(studentEntity -> scmRepository
                .findTopByStudentOrderByCreatedDateDesc(studentEntity)
                .map(MapperUtil::EntityToDTO).orElse(null)).orElse(null);

    }

    public ScmDTO findFirstMarkBySid(Long sid){
        Optional<StudentEntity> student = studentRepository.findById(sid);

        return student.map(studentEntity -> scmRepository
                .findFirstByStudentOrderByCreatedDateAsc(studentEntity)
                .map(MapperUtil::EntityToDTO).orElse(null)).orElse(null);

    }

    public ScmDTO findFirstMarkBySidAndCid(ScmDTO dto){
        Optional<StudentEntity> student = studentRepository.findById(dto.getSid());
        Optional<CourseEntity> course = courseRepository.findById(dto.getSid());

        if (student.isPresent() && course.isPresent()){
            return scmRepository
                    .findFirstByStudentAndCourseOrderByCreatedDateAsc(student.get(), course.get())
                    .map(MapperUtil::EntityToDTO)
                    .orElse(null);
        }

        return null;
    }

    public ScmDTO findTop3BySid(Long sid){
        Optional<StudentEntity> student = studentRepository.findById(sid);

        return student.map(studentEntity -> scmRepository
                .findTop3ByStudentOrderByMarkDesc(studentEntity)
                .map(MapperUtil::EntityToDTO).orElse(null)).orElse(null);

    }

}
