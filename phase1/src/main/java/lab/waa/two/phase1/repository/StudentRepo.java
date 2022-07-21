package lab.waa.two.phase1.repository;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
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
    return studentsDB;
  }

  public Student getById(Long id) {
    return studentsDB.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
  }

  public void update(Long id, Student updatedStudent) {
    long[] ids = studentsDB.stream().map(s -> s.getId()).mapToLong(Long::longValue).toArray();
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
      student.getCoursesTaken()));
  }

  public void delete(Long id) {
    studentsDB.removeIf(it -> it.getId() == id);
  }

  public List<Student> getStudentsByMajor(String major) {
    return studentsDB.stream()
      .filter(student -> student.getMajor().equals(major))
      .collect(Collectors.toList());
  }

  public List<Course> getCoursesByStudentId(Long id) {
    return studentsDB.stream().filter(s -> s.getId() == id)
      .findFirst()
      .orElseThrow(RuntimeException::new)
      .getCoursesTaken();
  }
}
