package nl.novi.les11model.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long courseId;
    private String title;
    private int sp;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long id) {
        this.courseId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
