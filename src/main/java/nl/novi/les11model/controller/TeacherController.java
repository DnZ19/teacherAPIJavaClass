package nl.novi.les11model.controller;

import jakarta.validation.Valid;
import nl.novi.les11model.dto.TeacherDto;
import nl.novi.les11model.model.TeachersStudents;
import nl.novi.les11model.service.TeacherService;
import nl.novi.les11model.service.TeachersStudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service){
        
        this.service = service;
        
    }

    @PostMapping
    public ResponseEntity<Object> createTeacher(@Valid @RequestBody TeacherDto tdto, BindingResult br) {

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        Long teacherId = service.createTeacher(tdto);
        tdto.teacherId = teacherId;


        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + teacherId).toUriString());

        return ResponseEntity.created(uri).body(tdto);

    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long teacherId){
        TeacherDto tdto = service.getTeacher(teacherId);

        return ResponseEntity.ok(tdto);
    }

//    @GetMapping("/before")
//    public ResponseEntity<Iterable<Teacher>> getTeacherBefore(@RequestParam LocalDate date){
//        return ResponseEntity.ok(repos.findByDobBefore(date));
//    }

}
