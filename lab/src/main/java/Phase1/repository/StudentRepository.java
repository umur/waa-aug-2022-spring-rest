package Phase1.repository;

import Phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private List<Student> studentsList = new ArrayList<>();

    private static int increamentId = 1;

    public StudentRepository() {

    }

    public List<Student> findAll() {
        return studentsList;
    }

    public Student findById(int id){

        return studentsList.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    public void createStudent(Student student){

        student.setId(increamentId);
        studentsList.add(student);

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
        studentsList.remove(std);
        return std;
    }

    public List<Student> findByMajor(String major) {
        return studentsList.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

}
