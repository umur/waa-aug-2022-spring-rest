package waa.phase1.repository;

import org.springframework.stereotype.Repository;
import waa.phase1.entity.Course;
import waa.phase1.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();

    {
        Course a = new Course(1, "WAA", 511, false);
        Course b = new Course(2, "WAP", 471, false);
        Course c = new Course(3, "ALG", 551, false);
        List<Course> student1 = new ArrayList<>();
        student1.add(a);
        student1.add(b);
        List<Course> student2 = new ArrayList<>();
        student2.add(a);
        student2.add(c);
        students.add(new Student(1, "Trung", "Le", "a@gmail.com", "Mr", (float) 3.7, student1, false));
        students.add(new Student(2, "Inan", "Umun", "b@gmail.com", "Mr", (float) 3.8, student2, false));
    }

    public List<Student> findAll() {
        return students;
    }

    public void deleteById(int id) {
        students = students.stream().filter(stu -> stu.getId() != id).collect(Collectors.toList());
    }

    public void save(Student student) {
        students.add(student);
    }

    public void update(int id, Student student) {
        Student needCheck = students.stream().filter(stu -> stu.getId() != id).collect(Collectors.toList()).get(0);
        if (needCheck != null) {
            students.remove(needCheck);
        }
        save(student);
    }
}
