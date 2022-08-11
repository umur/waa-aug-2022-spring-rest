package david.edu.min.Lab2.repository;

import david.edu.min.Lab2.entity.Course;
import david.edu.min.Lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {
    private  static List<Student> students= new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public void save(Student s) {
        Student student = students.stream().filter(e -> e.getId() == s.getId()).findFirst().orElse(null);
        if (student == null)
            students.add(s);
    }

    public void deleteById(int studentId)
    {
        Student student=  students.stream().filter(e->e.getId()==studentId).findFirst().orElse(null);
        students.remove(student);
    }

    public void update(int studentId,Student s)
    {
        Student student=  students.stream().filter(e->e.getId()==studentId).findFirst().orElse(null);
        if(student!=null)
            students.remove(student);
        save(s);
    }

    public Student getById(int studentId)
    {
        Student student=  students.stream().filter(e->e.getId()==studentId).findFirst().orElse(null);
        return student;
    }

    public List<Student> getStudentsByMajor(String major){
        Optional<Student> student = students.stream().filter(e -> e.getMajor().equals(major)).findAny();
        if(student.isPresent())
            return student.stream().toList();
        else
            return null;
    }

    public List<Course> getCoursesByStudentId(int studentId){
        Student student=  students.stream().filter(e->e.getId()==studentId).findFirst().orElse(null);
        if(student != null)
            return student.getCoursesTaken();
        else
            return null;
    }
}
