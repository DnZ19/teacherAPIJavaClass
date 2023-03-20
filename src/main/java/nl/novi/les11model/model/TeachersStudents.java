package nl.novi.les11model.model;

import jakarta.persistence.*;

@Entity
public class TeachersStudents {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher(Teacher teacher) {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent(Student student) {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
