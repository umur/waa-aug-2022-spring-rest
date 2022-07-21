package com.miu.demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.miu.demo.Domain.Course;
import com.miu.demo.Domain.Student;
@Repository
public class StudentRepo {
	private static List<Student> students = new ArrayList<>();

    static {
        Student student1 = new Student(1L,"Jharna","Karki","jkarki@gmail.com","compro");
       
        Course waaCourse = new Course(1L,"WAA","CS-543");
        
        student1.addCourse(waaCourse);
        
        
        students.add(student1);
       
    }

    public List<Student> findAll(){
        return students;
    }

    public Student save(Student student){
        this.students.add(student);
        return student;
    }

    public Student update(Student student, Long id){
        var mayBeStudent = students.stream().filter(stu -> stu.getId().equals(id)).findFirst();
        if(mayBeStudent.isPresent()){
            students.remove(mayBeStudent.get());
            students.add(student);
        }
        return student;
    }

    public void delete(Long id){
        var mayBeStudent = students.stream().filter(stu -> stu.getId().equals(id)).findFirst();
        if(mayBeStudent.isPresent()){
            students.remove(mayBeStudent.get());
            var student = mayBeStudent.get();
            student.setDeleted(true);
            students.add(student);
        }
    }

    public Student findById(Long id){
        return students.stream().filter(stu -> stu.getId().equals(id)).findFirst().get();
    }
}
