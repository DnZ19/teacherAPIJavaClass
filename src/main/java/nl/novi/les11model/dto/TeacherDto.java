package nl.novi.les11model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherDto {

    public Long teacherId;

    @NotBlank
    public String firstName;
    @Size(min=3, max=255)
    public String lastName;
    @Past
    public LocalDate dob;

    public List<String> courseTitles = new ArrayList<>();

}
