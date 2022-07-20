package miu.edu.lab2.repositories;

import miu.edu.lab2.exceptions.StudentNotFoundException;
import miu.edu.lab2.models.Course;
import miu.edu.lab2.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    public static List<Student> stduList = new ArrayList<>();

    public static void main(String[] args) {
        var courseList = new ArrayList<Course>();
        courseList.addAll(CourseRepo.courses);
        stduList.add(new Student(1, "Tom", "Hanks", "hanks@gmail.com", "CS", 3.6F, courseList));
        stduList.add(new Student(2, "Matt", "Damon", "damon@gmail.com", "MA", 3.7F ,courseList));

    }

    public List<Student> getAll(){
        return stduList;
    }

    public void save(Student student){
        stduList.add(student);
    }

    public void delete(Student student){
        stduList.add(student);
    }

    public List<Student> getStudentByMajor(String major){
        return stduList.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCourseListByStudentId(int studentId){
        var student = stduList.stream().filter(stu -> stu.getId() == studentId).findFirst();
        if(student.isPresent()){
            return student.get().getCoursesTaken();
        }else{
            throw new StudentNotFoundException();
        }
    }

}
