package miu.edu.test.repo;

import miu.edu.test.dto.StudentCreateDto;
import miu.edu.test.entity.Course;
import miu.edu.test.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students;
    static {
        Course c1 = CourseRepo.courses.get(0);
        Course c2= CourseRepo.courses.get(1);
        Course c3= CourseRepo.courses.get(2);

        students= new ArrayList<Student>();
        Student s1= new Student(Student.GetNextId(),"Sudi","Surendhar","sud@miu.edu","ComPro",new ArrayList<Course>(){{add(c1); add(c2);}}, false );
        Student s2= new Student(Student.GetNextId(),"Amit","Shah","amit@miu.edu","ComPro",new ArrayList<Course>(){{add(c3); add(c2);}}, false );
        Student s3= new Student(Student.GetNextId(),"Mak","Rony","mak@miu.edu","ComPro",new ArrayList<Course>(){{add(c1);}},false );
        Student s4= new Student(Student.GetNextId(),"Mohammad","Kadir","mohammad@miu.edu","ComPro",new ArrayList<Course>(){{add(c1); add(c2); add(c3);}},false);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
    }

    public Student save(Student s) {
        var notExists = students
                .stream()
                .noneMatch(l -> l.getId() == s.getId());

        if (notExists) {
            students.add(s);
            return s;
        }else {
            return null;
        }
    }

    public Student delete(int id) {
        // set deleted to true
        var student = students
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
        if(student!= null){
            student.setDeleted(true);
            return student;
        }

        return null;
    }

    public Student getById(int id) {
        return students
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public List<Student> getAll(){
        return  students.stream()
                .filter(l->!l.isDeleted())
                .collect(Collectors.toList());
    }

    public List<Student> getByMajor(String major){
        return  students.stream()
                .filter(l->!l.isDeleted() && l.getMajor().toLowerCase().equals(major.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Student Update(int id, StudentCreateDto stu, List<Course> courses){
        var stuDb = students.stream().filter(c -> !c.isDeleted() && c.getId() == id).findFirst().orElse(null);
        if(stu == null) {
            return null;
        }
        stuDb.setFirstName(stu.getFirstName());
        stuDb.setLastName(stu.getLastName());
        stuDb.setEmail(stu.getEmail());
        stuDb.setMajor(stu.getMajor());
        stuDb.setCoursesTaken(courses);
        return stuDb;
    }

}
