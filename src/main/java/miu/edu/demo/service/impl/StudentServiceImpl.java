package miu.edu.demo.service.impl;

import miu.edu.demo.dto.CourseDTO;
import miu.edu.demo.dto.StudentDTO;
import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;
import miu.edu.demo.repository.CourseRepo;
import miu.edu.demo.repository.StudentRepo;
import miu.edu.demo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        List<Student> studentList = studentRepo.filterStudents(st -> st.getMajor().equals(major));

        return studentList
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("No such student with id: " + studentId));
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO.getCoursesTaken();
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepo.findAll()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(int id) {
        return modelMapper.map(studentRepo.findById(id), StudentDTO.class);
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
    }

    @Override
    public void updateStudent(int id, StudentDTO studentDTO) {
        studentRepo.updateStudent(id, modelMapper.map(studentDTO, Student.class));
    }

    @Override
    public StudentDTO addCourseToStudent(int studentId, int courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("No such course with id: " + courseId));
        Student student = studentRepo.addCourse(studentId, course);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepo.deleteStudent(studentId);
    }

}
