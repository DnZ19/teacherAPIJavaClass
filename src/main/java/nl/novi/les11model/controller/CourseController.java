package nl.novi.les11model.controller;

import nl.novi.les11model.dto.CourseDto;
import nl.novi.les11model.model.Course;
import nl.novi.les11model.model.Teacher;
import nl.novi.les11model.repository.CourseRepository;
import nl.novi.les11model.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CourseController {

    private final CourseRepository courseRepos;
    private final TeacherRepository teacherRepos;

    //ipv service
    public CourseController(CourseRepository courseRepos, TeacherRepository teacherRepos) {
        this.courseRepos = courseRepos;
        this.teacherRepos = teacherRepos;
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {

        Course course = new Course();

        //mapp
        course.setTitle(courseDto.title);
        course.setSp(courseDto.sp);

        Teacher teacher = teacherRepos.findById(courseDto.teacherId).get(); // happy flow
        course.setTeacher(teacher);

        courseRepos.save(course);
        courseDto.id = course.getId();

        return new ResponseEntity<>(courseDto, HttpStatus.CREATED);

    }

}
