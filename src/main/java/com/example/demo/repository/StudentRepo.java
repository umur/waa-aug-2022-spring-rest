package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    public static List<Student> students = new ArrayList<>();

    public List<Student> getAll(){
        return students.stream().filter(s->s.isDeleted()).collect(Collectors.toList());
    }
    public Student getById(int id){
        return students.stream().filter(s->s.getId()==id).findFirst().orElse(null);
    }
    public void deleteStudent(int id){
        Student std = students.stream().filter(s->s.getId()==id).findFirst().orElse(null);
        if(std !=null){
            students.remove(std);
        }
    }
    public  void save(Student std){
        boolean notExists = students.stream().noneMatch(s->s.getId()==std.getId());
        if(notExists){
            students.add(std);
        }
    }
}
