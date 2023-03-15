package nl.novi.les11model.dto;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import nl.novi.les11model.model.Teacher;

public class CourseDto {

    public Long id;
    public String title;
    public int sp;

    public Long teacherId;
}
