package nkj.obligatoriskopgave.repository;

import nkj.obligatoriskopgave.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
