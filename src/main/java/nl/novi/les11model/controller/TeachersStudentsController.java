package nl.novi.les11model.controller;

import jakarta.validation.Valid;
import nl.novi.les11model.dto.TeachersStudentsDto;
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
@RequestMapping("teachersStudents")
public class TeachersStudentsController {

    private final TeachersStudentsService service;

    public TeachersStudentsController(TeachersStudentsService service){

        this.service = service;

    }

    @PostMapping
    public ResponseEntity<Object> createTeachersStudents(@Valid @RequestBody TeachersStudentsDto tsdto, BindingResult br){

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()){
                sb.append(fe.getField() + "; ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        Long id = service.createTeachersStudents(tsdto);
        tsdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(tsdto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachersStudentsDto> getTeachersStudents(@PathVariable Long id){
        TeachersStudentsDto tsdto = service.getTeachersStudents(id);

        return ResponseEntity.ok(tsdto);
    }


}

