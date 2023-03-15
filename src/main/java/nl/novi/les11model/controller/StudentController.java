package nl.novi.les11model.controller;

import nl.novi.les11model.dto.StudentDto;
import nl.novi.les11model.model.Student;
import nl.novi.les11model.repository.StudentRepository;
import nl.novi.les11model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService service;

//    @Autowired
//    StudentRepository repos;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping("/{studentNr}")
    public  ResponseEntity<StudentDto> getStudent(@PathVariable Long studentNr){
        StudentDto sdto = service.getStudent(studentNr);

        return ResponseEntity.ok(sdto);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        repos.save(s);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + s.getStudentNr()).toUriString());

        return ResponseEntity.created(uri).body(s);
    }

    @GetMapping("/nameSearch")
    public ResponseEntity<Iterable<StudentDto>> getStudents(@RequestParam String firstName){

        return ResponseEntity.ok(repos.findByFirstNameContaining(firstName));
    }

//    @PutMapping("/{studentNr}")
//    public ResponseEntity<Student> updateStudent(@PathVariable Long studentNr, @RequestBody Student updatedStudent) {
//
//        Optional<Student> existingStudent = StudentRepository.findById(studentNr);
//
//        if (!existingStudent.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Student student = existingStudent.get();
//
//        student.setFirstName(updatedStudent.getFirstName());
//        student.setLastName(updatedStudent.getLastName());
//        student.setPhoneNumber(updatedStudent.getPhoneNumber());
//
//        Student savedStudent = StudentRepository.save(student);
//
//        return ResponseEntity.ok(savedStudent);
//    }

}
