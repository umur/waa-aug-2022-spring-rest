package com.miu.lab.repository;


import com.miu.lab.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {

    private List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public Student getStudentsByMajor(String major){
        return students.stream().filter(s -> s.getMajor().equals(major)).findAny().orElse(null);
    }
    public Student getById(int studentId){
        return students.stream().filter(s -> s.getId()==studentId).findFirst().orElse(null);
    }

    public void save(Student st) {
        students.add(st);
    }

    //For now get then delete it and save new one , in real db will be update real field
    public Student update(Student st) {
        Optional<Student> currentStudent=students.stream().filter((Student s) -> s.getId()== st.getId()).findFirst();
        if(!currentStudent.isPresent())
            return  null;

        delete(currentStudent.get());

        save(st);

        return st;
    }

    public void delete(int studentId){
        Optional<Student> currentStudent=students.stream().filter((Student s) -> s.getId()== studentId).findFirst();
        if(!currentStudent.isPresent())
            return  ;

        students.remove(currentStudent.get());
    }
    public void delete(Student st){
        students.remove(st);
    }
}
