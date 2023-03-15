package nl.novi.les11model.controller;

import jakarta.validation.Valid;
import nl.novi.les11model.dto.TeacherDto;
import nl.novi.les11model.model.Teacher;
import nl.novi.les11model.repository.TeacherRepository;
import nl.novi.les11model.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {
    private final TeacherService service;

    //link met de repository
    //@Autowired
    //TeacherRepository repos;

    public TeacherController(TeacherService service){
        
        this.service = service;
        
    }

//    @GetMapping
//    public ResponseEntity<Iterable<Teacher>> getTeachers() {
//        return ResponseEntity.ok(repos.findAll());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long id){
        TeacherDto tdto = service.getTeacher(id);

        return ResponseEntity.ok(tdto);
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
        Long id = service.createTeacher(tdto);
        tdto.id = id;


        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(tdto);

    }

//    @GetMapping("/before")
//    public ResponseEntity<Iterable<Teacher>> getTeacherBefore(@RequestParam LocalDate date){
//        return ResponseEntity.ok(repos.findByDobBefore(date));
//    }

}
