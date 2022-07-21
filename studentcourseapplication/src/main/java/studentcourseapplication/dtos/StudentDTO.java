package studentcourseapplication.dtos;

import lombok.Data;
import studentcourseapplication.domain.Course;
import studentcourseapplication.domain.Student;

import java.util.ArrayList;
import java.util.List;


    @Data
    public class StudentDTO {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String major;
        private float gpa;
        private List<Course> courseList= new ArrayList<>();

        public StudentDTO(Long id, String firstName, String lastName, String email, String major, float gpa, List<Course> courseList) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.major = major;
            this.gpa = gpa;
            this.courseList.addAll(courseList);
        }

        public class StudentAdapter{
            public static  StudentDTO getStudentDTOFromStudent(Student student){
                return new StudentDTO(student.getId(),student.getFirstName(), student.getLastName() , student.getEmail(), student.getMajor(), student.getGpa(), student.getCourseList());
            }
            public static Student getStudentFromStudentDTO(StudentDTO studentDTO){
                return new Student(studentDTO.getId(),studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.email, studentDTO.getMajor(), studentDTO.getGpa(), studentDTO.getCourseList());
            }

            public static List<StudentDTO> getStudentDTOListFromStudentList(List<Student> students){
                List<StudentDTO> studentDTOS= new ArrayList<>();
                for(Student s : students){
                    studentDTOS.add(getStudentDTOFromStudent(s));
                }
                return studentDTOS;
            }
        }
}
