package miu.edu.lab2.service;

import miu.edu.lab2.dto.CourseDTO;
import miu.edu.lab2.dto.StudentDTO;
import miu.edu.lab2.entity.Course;
import miu.edu.lab2.entity.Student;
import miu.edu.lab2.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    private static int idCounter = 1;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    public List<Student> getStudentsByMajor(String major){
        return studentRepository.findByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int studentId){
        Student student = studentRepository.findById(studentId);
        return  student.getCoursesTaken();
    }
    public Student findStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(StudentDTO studentDTO) {
        Student student = toStudent(studentDTO);
        studentRepository.save(student);
        return student;
    }

    public Student updateStudent(StudentDTO studentDTO) throws Exception {
        Student student = toStudent(studentDTO);
        return studentRepository.update(student);
    }

    public Student deleteStudentById(int studentId) throws Exception {
        return studentRepository.delete(studentId);
    }

    public Student toStudent(StudentDTO studentDTO) {
        List<Course> courseList = new ArrayList<>();
        for(CourseDTO courseDto: studentDTO.getCoursesTaken()) {
            Course newCourse = modelMapper.map(courseDto, Course.class);
            courseList.add(newCourse);
        }

        Student student = modelMapper.map(studentDTO, Student.class);
        student.setCoursesTaken(courseList);

        if(studentDTO.getId() == 0) {
            student.setId(idCounter++);
        }
        return student;
    }
}
