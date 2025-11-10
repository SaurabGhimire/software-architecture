package customers.repository;

import customers.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    Collection<Student> findByName(String name);
    Optional<Student> findByPhoneNumber(long phoneNumber);
    Collection<Student> findByAddress_City(String city);

}
