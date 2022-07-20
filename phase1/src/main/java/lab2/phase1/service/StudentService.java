package lab2.phase1.service;

import lab2.phase1.domain.Course;
import lab2.phase1.domain.Student;
import lab2.phase1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Boolean create(Student stu) {
        return repo.create(stu);
    }

    @Override
    public List<Student> read() {
        return repo.read();
    }

    @Override
    public Boolean update(int id, Student stu) {
        return repo.update(id, stu);
    }

    @Override
    public Boolean delete(int id) {
        return repo.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return repo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return repo.getCoursesByStudentId(studentId);
    }
}
