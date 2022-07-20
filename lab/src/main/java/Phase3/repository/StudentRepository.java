package Phase3.repository;

import Phase3.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> studentList = new ArrayList<>();

    StudentRepository() {}
    public List<Student> findAll() {
        return studentList;
    }

    public Student findById(int studentId){
        return studentList.stream().filter(student -> student.getId() == studentId).findFirst().orElse(null);
    }

    public void createOne(Student student) {
        studentList.add(student);
    }

    public Student updateOne(Student student) throws Exception {

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

    public List<Student> findByMajor(String major) {
        return studentList.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

}
