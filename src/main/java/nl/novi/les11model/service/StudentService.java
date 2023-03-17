package nl.novi.les11model.service;

import nl.novi.les11model.dto.StudentDto;
import nl.novi.les11model.exception.ResourceNotFoundException;
import nl.novi.les11model.model.Student;
import nl.novi.les11model.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //ipv autowired
    private final StudentRepository repos;

    public StudentService(StudentRepository repos) {

        this.repos = repos;

    }

    public Long createStudent(StudentDto sdto) {


        Student s  = new Student();
        s.setFirstName(sdto.firstName);
        s.setLastName(sdto.lastName);
        s.setPhoneNumber(sdto.phoneNumber);

        repos.save(s);

        return s.getStudentNr();

    }

    public StudentDto getStudent(Long studentNr) {
        Student s = repos.findById(studentNr).orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        StudentDto sdto = new StudentDto();
        sdto.studentNr = s.getStudentNr();
        sdto.firstName = s.getFirstName();
        sdto.lastName = s.getLastName();
        sdto.phoneNumber = s.getPhoneNumber();

        return sdto;

    }


}
