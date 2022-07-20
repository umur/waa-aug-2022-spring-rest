package com.miu.demo.repo;


import com.miu.demo.domain.Course;
import com.miu.demo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();

    static {
        Student student1 = new Student(1L,"Jharna","Karki","jharna@gmail.com","compro",null);
        Course mwaCourse = new Course(1L,"MWA","CS-546");
        student1.addCourse(mwaCourse);

        students.add(student1);

    }

    private static Long counter = 2L;

    public Long getCounter(){
        return StudentRepository.counter++;
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
