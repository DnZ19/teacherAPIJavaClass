package nl.novi.les11model.repository;


import nl.novi.les11model.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface TeacherRepository extends CrudRepository <Teacher, Long> {

    //query
Iterable<Teacher> findByDobBefore(LocalDate date);

}


