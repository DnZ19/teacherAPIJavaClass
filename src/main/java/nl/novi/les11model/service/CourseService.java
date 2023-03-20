package nl.novi.les11model.service;

import nl.novi.les11model.dto.CourseDto;
import nl.novi.les11model.exception.ResourceNotFoundException;
import nl.novi.les11model.model.Course;
import nl.novi.les11model.model.Teacher;
import nl.novi.les11model.repository.CourseRepository;
import nl.novi.les11model.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository repos;
    private final TeacherRepository teacherRepos;

    public CourseService(CourseRepository repos, TeacherRepository teacherRepos){

        this.repos = repos;
        this.teacherRepos = teacherRepos;

    }

    public Long createCourse(CourseDto cdto){

        Course c = new Course();
        c.setTitle(cdto.title);
        c.setSp(cdto.sp);

        Teacher teacher = teacherRepos.findById(cdto.teacherId).get();
        c.setTeacher(teacher);

        repos.save(c);

        return c.getCourseId();

    }

    public CourseDto getCourse(Long courseId) {
        Course c = repos.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        CourseDto cdto = new CourseDto();
        cdto.courseId = c.getCourseId();
        cdto.title = c.getTitle();
        cdto.sp = c.getSp();

        return cdto;

    }

}
