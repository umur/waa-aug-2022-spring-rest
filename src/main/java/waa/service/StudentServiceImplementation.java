package waa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import waa.domain.Course;
import waa.domain.Student;
import waa.dto.CourseDTO;
import waa.dto.StudentDTO;
import waa.repository.StudentRepository;

import java.util.List;

@Service
@Profile("DTOMapper")
public class StudentServiceImplementation implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DtoObjectMapper dtoObjectMapper;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = dtoObjectMapper.getStudentFromStudentDTO(studentDTO);
        studentRepository.create(student);
        return studentDTO;
    }

    @Override
    public List<StudentDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return dtoObjectMapper.getStudentDTOs(students);
    }

    @Override
    public StudentDTO findStudentById(Integer studentId) {
        Student student = studentRepository.findById(studentId);
        return dtoObjectMapper.getStudentDTOFromStudent(student);
    }

    @Override
    public List<StudentDTO> findStudentByMajor(String major) {
        List<Student> students = studentRepository.findByMajor(major);
        return dtoObjectMapper.getStudentDTOs(students);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws Exception {
        Student student = dtoObjectMapper.getStudentFromStudentDTO(studentDTO);
        studentRepository.updateStudent(student);
        return studentDTO;
    }

    @Override
    public StudentDTO removeStudentById(Integer studentId) throws Exception {
        Student student = studentRepository.removeById(studentId);
        return dtoObjectMapper.getStudentDTOFromStudent(student);
    }

    @Override
    public List<CourseDTO> findCoursesByStudentId(Integer studentId) {
        List<Course> courses = studentRepository.findById(studentId).getCoursesTaken();
        return dtoObjectMapper.getCourseDTOList(courses);
    }
}
