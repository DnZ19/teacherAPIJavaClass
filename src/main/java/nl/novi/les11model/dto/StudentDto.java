package nl.novi.les11model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;



public class StudentDto {

    public Long studentNr;

    @NotBlank
    public String firstName;
    @Size(min=3, max=255)
    public String lastName;
    @Length(min=10)
    public Long phoneNumber;

}
