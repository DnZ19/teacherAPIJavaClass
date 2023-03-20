package nl.novi.les11model.service;

import nl.novi.les11model.dto.TeacherDto;
import nl.novi.les11model.exception.ResourceNotFoundException;
import nl.novi.les11model.model.Course;
import nl.novi.les11model.model.Teacher;
import nl.novi.les11model.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    //nette manier ipv autowired
    private final TeacherRepository repos;

    public TeacherService(TeacherRepository repos) {

        this.repos = repos;

    }

    public Long createTeacher(TeacherDto tdto) {
        //mappning naar entiteit

        Teacher t = new Teacher();
        t.setFirstName(tdto.firstName);
        t.setLastName(tdto.lastName);
        t.setDob(tdto.dob);

        repos.save(t);

        return t.getTeacherId();

    }

    public TeacherDto getTeacher(Long id) {
        Teacher t = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        //map naar dto
        TeacherDto tdto = new TeacherDto();
        tdto.teacherId = t.getTeacherId();
        tdto.firstName = t.getFirstName();
        tdto.lastName = t.getLastName();
        tdto.dob = t.getDob();

        for (Course c : t.getCourses()){
            tdto.courseTitles.add(c.getTitle());
        }

        return tdto;

    }


}
