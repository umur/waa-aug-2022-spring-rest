package edu.miu.restphaseIV.repository;

import edu.miu.restphaseIV.entity.Course;
import edu.miu.restphaseIV.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students;

    static {
        students = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setFirstname("Amgalan");
        student.setLastname("Bat-Erdene");
        student.setEmail("amgalan.baterdene@miu.edu");
        student.setMajor("ComPro");
        student.setGpa(4);

        var coursesTaken = new ArrayList<Course>();
        var courseRepo = new CourseRepo();
        coursesTaken.add(courseRepo.getById(1));
        coursesTaken.add(courseRepo.getById(2));
        student.setCoursesTaken(coursesTaken);

        students.add(student);
    }

    public Student save(Student student) {
        Boolean notExists = students.stream().noneMatch(s -> s.getId() == student.getId());
        if(notExists) {
            students.add(student);
            return student;
        }
        return null;
    }

    public void update(Student student) {
        Student existingStudent = this.getById(student.getId());
        if(existingStudent != null) {
            students.set(students.indexOf(existingStudent), student);
        }
    }

    public Student delete(int id) {
        Student student = getById(id);
        if(student != null){
            students.remove(student);
        }
        return student;
    }

    public Student getById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAll() {
        return students.stream().filter(s -> !s.isDeleted()).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return this.getById(studentId).getCoursesTaken();
    }

    public List<Course> deleteCourseFromStudent(int id, int courseId) {
        var student = getById(id);
        List<Course> courses = null;
        if(student != null) {
            courses = student.getCoursesTaken();
            var course = courses.stream().filter(c -> c.getId() == courseId).findFirst().orElse(null);
            if(course != null) {
                courses.remove(course);
                student.setCoursesTaken(courses);
            }
        }
        return courses;
    }

    public List<Course> addCourseToStudent(int id, Course course) {
        var student = getById(id);
        List<Course> courses = null;
        if(student != null) {
            courses = student.getCoursesTaken();
            if(courses.stream().filter(c -> c == course).findFirst().orElse(null) == null) {
                courses.add(course);
                student.setCoursesTaken(courses);
            }
        }
        return courses;
    }

    public List<Student> getStudentsByMajor(String major) {return students.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());}
}
