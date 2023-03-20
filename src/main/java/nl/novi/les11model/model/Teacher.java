package nl.novi.les11model.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long teacherId;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    @OneToMany(mappedBy = "teacher")
    private List<TeachersStudents> teachersStudents;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<TeachersStudents> getTeachersStudents() {
        return teachersStudents;
    }

    public void setTeachersStudents(List<TeachersStudents> teachersStudents) {
        this.teachersStudents = teachersStudents;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}
