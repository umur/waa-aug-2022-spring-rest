package com.example.lab2waa.phase2.Repository;

import com.example.lab2waa.phase2.Model.Course;
import com.example.lab2waa.phase2.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    int id = 4;
    private List<Student> students = new ArrayList<>();

    public StudentRepository(){
        Course course1 = new Course(123,"ClCmp", "CS555");
        Course course2 = new Course(456,"WAP", "CS425");
        Course course3 = new Course(789,"SE", "CS475");
        List<Course> cources = List.of(course1,course2,course3);

        Student student1 = new Student(1,"Elbek","Shaykulov","a@a.com","CS",cources,3.31);
        Student student2 = new Student(2,"Floyd","Mayweather","b@b.com","MBA",cources,3.8);
        Student student3 = new Student(3,"Saul","Alvares","c@c.com","LAW",cources,3.98);

        students.addAll(List.of(student1, student2));
    }

    public List<Student> findAll(){
        return students;
    }



    //Implement getStudentsByMajor(String major) method.
    //Returns all students majoring major.
    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter(student -> student.getMajor() == major).collect(Collectors.toList());
    }

    //    Implement getCoursesByStudentId(int studentId) method.
    //    Returns all courses of the student.
    public List<Course> getCoursesByStudentId(int studentId){
        Student student = findById(studentId);
        return student.getCoursesTaken();
    }

    //CRUD
    public Student findById(int id){
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public Student addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
        return student;
    }

    public Student updateStudent(Student student){
        int studentId = student.getId();
        Student updatedStudent = findById(studentId);
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setMajor(student.getMajor());
        updatedStudent.setCoursesTaken(student.getCoursesTaken());
        updatedStudent.setGpa(student.getGpa());
        updatedStudent.setEmail(student.getEmail());
        return updatedStudent;
    }

    public void deleteStudent(int id){
        Student student = findById(id);
        students.remove(student);
    }
}
