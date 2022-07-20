package waa.repository;


import org.springframework.stereotype.Repository;
import waa.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> studentList = new ArrayList<>();
    private static int idIncrement = 1;

    public  void create(Student student){
        student.setId(idIncrement++);
        studentList.add(student);
    }

    public Student findById(Integer id) {
        return   studentList.stream().filter(s->s.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> findAll() {
        return studentList;
    }

    public List<Student> findByMajor(String major) {
        return studentList.stream().filter(s->s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public Student updateStudent(Student student) throws Exception {

        int id = student.getId();
        Student std = findById(id);

        if(std == null) {
            throw new Exception("Student not found");
        }

        std.setEmail(student.getEmail());
        std.setCoursesTaken(student.getCoursesTaken());
        std.setFirstName(student.getFirstName());
        std.setGpa(student.getGpa());
        std.setMajor(student.getMajor());

        return std;
    }

    public Student removeById(int studentId) throws Exception {
        Student std = findById(studentId);
        if(std == null) throw new Exception("Not found");
        studentList.remove(std);
        return std;
    }
}
