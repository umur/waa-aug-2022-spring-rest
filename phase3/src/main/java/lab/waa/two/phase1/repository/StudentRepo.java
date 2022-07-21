package lab.waa.two.phase1.repository;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import lombok.var;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

  private static List<Student> studentsDB = new ArrayList<Student>();
  private Long idCounter = 1L;

  public List<Student> getAll() {
    return studentsDB.stream().filter(s -> !s.isDeleted()).collect(Collectors.toList());
  }

  public Student getById(Long id) {
    return studentsDB.stream().filter(d -> d.getId().equals(id) && !d.isDeleted()).findFirst().orElse(null);
  }

  public void update(Long id, Student updatedStudent) {
    long[] ids = studentsDB.stream().filter(s -> !s.isDeleted()).map(s -> s.getId()).mapToLong(Long::longValue).toArray();
    int index = Arrays.binarySearch(ids, id);
    if(index < 0) {
      throw new RuntimeException("Student id not found");
    }
    updatedStudent.setId(studentsDB.get(index).getId());
    studentsDB.set(index, updatedStudent);
  }

  public void save(Student student) {
    studentsDB.add(new Student(++idCounter,
      student.getFirstName(), student.getLastName(),
      student.getEmail(),
      student.getMajor(),
      student.getGpa(),
      student.getCoursesTaken(),
      false));
  }

  public void delete(Long id) {
    var student = studentsDB.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

    if(student != null) {
      student.setDeleted(true);
    }
  }

  public List<Student> getStudentsByMajor(String major) {
    return studentsDB.stream()
      .filter(student -> !student.isDeleted() && student.getMajor().toLowerCase().equals(major.toLowerCase()))
      .collect(Collectors.toList());
  }

  public List<Course> getCoursesByStudentId(Long id) {
    return studentsDB.stream().filter(s -> !s.isDeleted() && s.getId() == id)
      .findFirst()
      .orElseThrow(RuntimeException::new)
      .getCoursesTaken();
  }
}
