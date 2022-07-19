package miu.edu.demo.repository;

import miu.edu.demo.entity.Course;
import miu.edu.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CourseRepo {
    private static List<Course> courseList = new ArrayList<>();


    public void save(Course course) {
        courseList.add(course);
    }

    public List<Course> findAll(){
        return courseList
                .stream()
                .filter(course -> !course.isDeleted())
                .collect(Collectors.toList());
    }

    public Optional<Course> findById(int id) {
        return courseList
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    public void deleteById(int id) {
        courseList.remove(id);
    }

    public void update(int id, Course updatedCourse) {

        int index = IntStream.range(0, courseList.size())
                .filter(i -> id == courseList.get(i).getId())
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such course with id: " + id));

        courseList.set(index, updatedCourse);

    }

    public List<Course> filterCourses(Predicate<Course> predicate) {
        return courseList
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
