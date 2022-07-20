package lab.waa.two.phase1.repository;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepo {
  private static List<Course> courseDB = new ArrayList<>();
  private static Long idCounter = 1L;

  public CourseRepo() {
    courseDB.add(new Course(++idCounter, "WAP", "CS01"));
    courseDB.add(new Course(++idCounter, "WAA", "CS02"));
    courseDB.add(new Course(++idCounter, "MPP", "CS03"));
    courseDB.add(new Course(++idCounter, "SWA", "CS04"));
  }

  public List<Course> getAll() {
    return courseDB;
  }

  public Course getById(Long id) {
    return courseDB.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
  }

  public void update(Long id, Course updatedCourse) {
    long[] ids = courseDB.stream().map(s -> s.getId()).mapToLong(Long::longValue).toArray();
    int index = Arrays.binarySearch(ids, id);
    if(index < 0) {
      throw new RuntimeException("Student id not found");
    }
    updatedCourse.setId(courseDB.get(index).getId());
    courseDB.set(index, updatedCourse);
  }

  public void save(Course course) {
    courseDB.add(new Course(++idCounter, course.getName(), course.getCode()));
  }

  public void delete(Long id) {
    courseDB.removeIf(it -> it.getId() == id);
  }
}
