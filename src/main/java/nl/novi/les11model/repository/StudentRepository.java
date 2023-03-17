package nl.novi.les11model.repository;

import nl.novi.les11model.model.Student;
import org.springframework.data.repository.CrudRepository;
import java.util.Collection;

public interface StudentRepository extends CrudRepository<Student, Long> {

   Collection<Student> findByFirstNameContaining(String queryFirstName);


}


