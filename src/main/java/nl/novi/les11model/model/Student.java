package nl.novi.les11model.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long studentNr;
    private String firstName;
    private String lastName;
    private Long phoneNumber;

    @OneToMany(mappedBy = "student")
    private List<TeachersStudents> teachersStudents;

    public List<TeachersStudents> getTeachersStudents() {
        return teachersStudents;
    }

    public void setTeachersStudents(List<TeachersStudents> teachersStudents) {
        this.teachersStudents = teachersStudents;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(Long studentNr) {
        this.studentNr = studentNr;
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
}
