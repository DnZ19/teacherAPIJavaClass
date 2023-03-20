package nl.novi.les11model.repository;

import nl.novi.les11model.model.Course;
import nl.novi.les11model.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CourseRepository extends CrudRepository<Course, Long> {

//    Collection<Course> findByTitleContaining(String queryTitle);

}
