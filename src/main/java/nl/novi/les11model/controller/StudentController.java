package nl.novi.les11model.controller;

import jakarta.validation.Valid;
import nl.novi.les11model.dto.StudentDto;
import nl.novi.les11model.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){

        this.service = service;

    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentDto sdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()){
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        Long studentNr = service.createStudent(sdto);
        sdto.studentNr = studentNr;

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + studentNr).toUriString());

        return ResponseEntity.created(uri).body(sdto);

    }

    @GetMapping("/{studentNr}")
    public  ResponseEntity<StudentDto> getStudent(@PathVariable Long studentNr){
        StudentDto sdto = service.getStudent(studentNr);

        return ResponseEntity.ok(sdto);
    }

//    @GetMapping("/nameSearch")
//    public ResponseEntity<Iterable<StudentDto>> getStudents(@RequestParam String firstName){
//
//        return ResponseEntity.ok(Student.findByFirstNameContaining(firstName));
//    }

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
