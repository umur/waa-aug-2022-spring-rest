package miu.edu.lab02.service;

import miu.edu.lab02.dto.CourseDTO;
import miu.edu.lab02.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

interface StudentService {
    List<StudentDTO> findAll();

    StudentDTO save(StudentDTO student);

    StudentDTO update(Integer id, StudentDTO student);

    Optional<StudentDTO> findOne(Integer id);

    void delete(Integer id);

    StudentDTO addCourse(Integer studentId, String courseCode);

    StudentDTO removeCourse(Integer studentId, String courseCode);

    List<StudentDTO> getStudentsByMajor(String major);

    List<CourseDTO> getCoursesByStudentId(Integer id);
}
