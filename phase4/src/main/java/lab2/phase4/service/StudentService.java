package lab2.phase4.service;

import lab2.phase4.domain.Course;
import lab2.phase4.domain.Student;
import lab2.phase4.dto.CourseDTO;
import lab2.phase4.dto.StudentDTO;
import lab2.phase4.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public StudentService(StudentRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Boolean create(StudentDTO stu) {
        return repo.create(mapper.map(stu, Student.class));
    }

    @Override
    public List<StudentDTO> read() {
        var data = repo.read();
        var result = new ArrayList<StudentDTO>();
        data.forEach(e -> {
            result.add(mapper.map(e, StudentDTO.class));
        });
        return result;
    }

    @Override
    public Boolean update(int id, StudentDTO stu) {
        return repo.update(id, mapper.map(stu, Student.class));
    }

    @Override
    public Boolean delete(int id) {
        return repo.delete(id);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        var data = repo.getStudentsByMajor(major);
        var result = new ArrayList<StudentDTO>();
        data.forEach(e -> {
            result.add(mapper.map(e, StudentDTO.class));
        });
        return result;
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        var data = repo.getCoursesByStudentId(studentId);
        var result = new ArrayList<CourseDTO>();
        data.forEach(e -> result.add(mapper.map(e, CourseDTO.class)));
        return result;
    }
}
