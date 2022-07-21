package studentcourseapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentcourseapplication.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
