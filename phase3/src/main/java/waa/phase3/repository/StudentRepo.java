package waa.phase3.repository;

import org.springframework.stereotype.Repository;
import waa.phase3.dto.CourseDto;
import waa.phase3.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static final List<Student> students = new ArrayList<>();

    {
        CourseDto a = new CourseDto(1, "WAA", 511);
        CourseDto b = new CourseDto(2, "WAP", 471);
        CourseDto c = new CourseDto(3, "ALG", 551);
        List<CourseDto> student1 = new ArrayList<>();
        student1.add(a);
        student1.add(b);
        List<CourseDto> student2 = new ArrayList<>();
        student2.add(a);
        student2.add(c);
        students.add(new Student(1, "Trung", "Le", "a@gmail.com", "Mr", 3.7, student1, false));
        students.add(new Student(2, "Inan", "Umun", "b@gmail.com", "Mr", 3.8, student2, false));
    }

    public List<Student> findAll() {
        return students.stream().filter(stu -> !stu.isDeleted()).collect(Collectors.toList());
    }

    public void deleteById(int id) {
        students.stream().filter(stu -> stu.getId() == id).forEach(stu -> stu.setDeleted(true));
    }

    public void save(Student student) {
        students.add(student);
    }

    public void update(int id, Student student) {
        if (id != student.getId()) return;
        Student needCheck = students.stream().filter(stu -> stu.getId() == id).collect(Collectors.toList()).get(0);
        if (needCheck != null) {
            students.remove(needCheck);
        }
        save(student);
    }

    public Student findById(int id) {
        return students.stream().filter(stu -> !stu.isDeleted() && stu.getId() == id).collect(Collectors.toList()).get(0);
    }
}
