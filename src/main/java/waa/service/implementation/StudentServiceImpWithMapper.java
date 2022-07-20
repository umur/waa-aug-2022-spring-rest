package waa.service.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import waa.domain.Course;
import waa.domain.Student;
import waa.dto.CourseDTO;
import waa.dto.StudentDTO;
import waa.repository.StudentRepository;
import waa.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("ModelMapper")
public class StudentServiceImpWithMapper implements StudentService {


    @Autowired
    StudentRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        repository.create(student);
        return studentDTO;
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        List<Student>students = repository.findAll();
        List<StudentDTO> studentDTOs = students.stream()
                .map(s->modelMapper.map(s,StudentDTO.class))
                .collect(Collectors.toList());
        return studentDTOs;
    }

    @Override
    public StudentDTO findStudentById(Integer studentId) {
        Student student = repository.findById(studentId);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> findStudentByMajor(String major) {
        List<Student> students = repository.findByMajor(major);
        List<StudentDTO> studentDTOs = students.stream()
                .map(s->modelMapper.map(s, StudentDTO.class)).collect(Collectors.toList());
        return studentDTOs;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDto) throws Exception {
        repository.updateStudent(modelMapper.map(studentDto, Student.class));
        return studentDto;
    }

    @Override
    public StudentDTO removeStudentById(Integer studentId) throws Exception {
        StudentDTO studentDTO = modelMapper.map(repository.removeById(studentId), StudentDTO.class);
        return studentDTO;
    }

    @Override
    public List<CourseDTO> findCoursesByStudentId(Integer studentId) {
        List<Course> courses = repository.findById(studentId).getCoursesTaken();
        List<CourseDTO> courseDTOs = courses.stream()
                .map(c->modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
        return courseDTOs;
    }
}
