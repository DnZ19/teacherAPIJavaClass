package nl.novi.les11model.controller;


import jakarta.validation.Valid;
import nl.novi.les11model.dto.CourseDto;
import nl.novi.les11model.repository.CourseRepository;
import nl.novi.les11model.repository.TeacherRepository;
import nl.novi.les11model.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service){

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseDto cdto, BindingResult br){

        if (br.hasFieldErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()){
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        Long courseId = service.createCourse(cdto);
        cdto.courseId = courseId;

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + courseId).toUriString());

        return ResponseEntity.created(uri).body(cdto);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long courseId){
        CourseDto cdto = service.getCourse(courseId);

        return ResponseEntity.ok(cdto);
    }

}
