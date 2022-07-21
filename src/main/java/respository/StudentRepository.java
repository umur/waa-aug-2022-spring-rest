package respository;

import domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    public List<Student>findAll(){
        return students;
    }
    public void create(Student s){
        students.add(s);
    }
    public void deleteById(int id){
        students.remove(id-1);
    }
    public Student findById(int id){
        return students.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .orElse(null);
    }
}
