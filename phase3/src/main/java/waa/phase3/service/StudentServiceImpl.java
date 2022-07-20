package waa.phase3.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.phase3.dto.CourseDto;
import waa.phase3.dto.StudentDto;
import waa.phase3.entity.Student;
import waa.phase3.repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> findAll() {
        var students = studentRepo.findAll();
        var result = new ArrayList<StudentDto>();
        students.forEach(course -> {
            result.add(modelMapper.map(course, StudentDto.class));
        });
        return result;
    }

    @Override
    public void save(StudentDto stu) {
        studentRepo.save(modelMapper.map(stu, Student.class));
    }

    @Override
    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public StudentDto findById(int id) {
        return modelMapper.map(studentRepo.findById(id), StudentDto.class);
    }

    @Override
    public void update(int id, StudentDto stu) {
        studentRepo.update(id, modelMapper.map(stu, Student.class));
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        Student result = studentRepo.findAll().stream().filter(stu -> stu.getId() == studentId).collect(Collectors.toList()).get(0);
        return result.getCoursesTaken();
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var students = studentRepo.findAll().stream().filter(stu -> stu.getMajor().equalsIgnoreCase(major)).collect(Collectors.toList());
        var result = new ArrayList<StudentDto>();
        students.forEach(stu -> {
            result.add(modelMapper.map(stu, StudentDto.class));
        });
        return result;
    }
}

