package nl.novi.les11model.service;

import nl.novi.les11model.dto.TeachersStudentsDto;
import nl.novi.les11model.exception.ResourceNotFoundException;
import nl.novi.les11model.model.TeachersStudents;
import nl.novi.les11model.repository.TeachersStudentsRepository;
import org.springframework.stereotype.Service;

@Service
public class TeachersStudentsService {

    private final TeachersStudentsRepository tsRepos;

    public TeachersStudentsService(TeachersStudentsRepository tsRepos){

        this.tsRepos = tsRepos;

    }

    public Long createTeachersStudents(TeachersStudentsDto tsdto){

        TeachersStudents ts = new TeachersStudents();
        ts.setStudent(tsdto.student);
        ts.setTeacher(tsdto.teacher);

        tsRepos.save(ts);

        return ts.getId();

    }

    public TeachersStudentsDto getTeachersStudents(Long id){
        TeachersStudents ts = tsRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Can't find connection between teacher and student"));

        TeachersStudentsDto tsdto = new TeachersStudentsDto();
        tsdto.id = ts.getId();
        tsdto.student = ts.getStudent(tsdto.student);
        tsdto.teacher = ts.getTeacher(tsdto.teacher);

        return tsdto;


    }


}
