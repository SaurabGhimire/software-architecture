package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByName(String name);
    Student findByPhoneNumber(long phoneNumber);
    @Query("select s from Student s where s.address.city = :city")
    Collection<Student> findByCity(@Param("city") String city);
}
