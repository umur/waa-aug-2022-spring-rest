package lab2.phase3.service;

import lab2.phase3.domain.Course;
import lab2.phase3.domain.Student;
import lab2.phase3.dto.CourseDTO;
import lab2.phase3.dto.StudentDTO;
import lab2.phase3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Boolean create(StudentDTO stu) {
        var studentCourses = new ArrayList<Course>();
        if (stu.getCoursesTaken() != null)
            stu.getCoursesTaken().forEach(e->studentCourses.add(new Course(e.getId(),e.getName(),e.getCode())));
        return repo.create(new Student(stu.getId(),stu.getFirstname(),stu.getLastname(),stu.getEmail(),stu.getMajor(),studentCourses,stu.getGpa()));
    }

    @Override
    public List<StudentDTO> read() {
        var data = repo.read();
        var result = new ArrayList<StudentDTO>();
        data.forEach(e-> {
            var coursesMapped = new ArrayList<CourseDTO>();
            if (e.getCoursesTaken() != null)
                e.getCoursesTaken().forEach(w->coursesMapped.add(new CourseDTO(w.getId(),w.getName(),w.getCode())));
            result.add(new StudentDTO(e.getId(),e.getFirstname(),e.getLastname(),e.getEmail(),e.getMajor(),coursesMapped,e.getGpa()));
        });
        return result;
    }

    @Override
    public Boolean update(int id, StudentDTO stu) {
        var studentCourses = new ArrayList<Course>();
        if (stu.getCoursesTaken() != null)
            stu.getCoursesTaken().forEach(e->studentCourses.add(new Course(e.getId(),e.getName(),e.getCode())));
        return repo.update(id, new Student(stu.getId(),stu.getFirstname(),stu.getLastname(),stu.getEmail(),stu.getMajor(),studentCourses,stu.getGpa()));
    }

    @Override
    public Boolean delete(int id) {
        return repo.delete(id);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        var data = repo.getStudentsByMajor(major);
        var result = new ArrayList<StudentDTO>();
        data.forEach(e->{
            var coursesMapped = new ArrayList<CourseDTO>();
            if (e.getCoursesTaken() != null)
                e.getCoursesTaken().forEach(w->coursesMapped.add(new CourseDTO(w.getId(),w.getName(),w.getCode())));
            result.add(new StudentDTO(e.getId(),e.getFirstname(),e.getLastname(),e.getEmail(),e.getMajor(),coursesMapped,e.getGpa()));
        });
        return result;
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        var data = repo.getCoursesByStudentId(studentId);
        var result = new ArrayList<CourseDTO>();
        data.forEach(e->result.add(new CourseDTO(e.getId(),e.getName(),e.getCode())));
        return result;
    }
}
