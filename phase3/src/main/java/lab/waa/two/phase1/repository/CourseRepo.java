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
public class CourseRepo {
  private static List<Course> courseDB = new ArrayList<>();
  private static Long idCounter = 1L;

  public List<Course> getAll() {
    var co = courseDB.stream()
      .filter(c -> !c.isDeleted())
      .collect(Collectors.toList());
    System.out.println(co.toString());
    return co;
  }

  public Course getById(Long id) {
    return courseDB.stream()
      .filter(c -> c.getId().equals(id) && !c.isDeleted())
      .findFirst()
      .orElse(null);
  }

  public void update(Long id, Course updatedCourse) {
    var course = courseDB.stream().filter(c -> !c.isDeleted() && c.getId() == id).findFirst().orElse(null);
    if(course == null) {
      throw new RuntimeException("Course not found by id");
    }
    course.setCode(updatedCourse.getCode());
    course.setName(updatedCourse.getName());
  }

  public void save(Course course) {
    courseDB.add(new Course(++idCounter, course.getName(), course.getCode(), false));
  }

  public void delete(Long id) {
    var course = courseDB.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

    if(course != null) {
      course.setDeleted(true);
    }
  }
}
