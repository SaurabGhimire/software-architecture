package app;

import java.util.Collection;
import java.util.List;

import domain.Address;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class StudentApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(
				"Anil Shrestha", 9801123456L, "anil.shrestha@email.com",
				new Address("Kathmandu Road", "Kathmandu", 44600)
		);

		Student student2 = new Student(
				"Sita Gurung", 9802234567L, "sita.gurung@email.com",
				new Address("Pokhara Lane", "Pokhara", 33700)
		);

		Student student3 = new Student(
				"Anil Shrestha", 9803345678L, "aneel.shrestha@email.com",
				new Address("Lalitpur Street", "Kathmandu", 44700)
		);

		Student student4 = new Student(
				"Maya Koirala", 9804456789L, "maya.koirala@email.com",
				new Address("Biratnagar Road", "Biratnagar", 56600)
		);

		Student student5 = new Student(
				"Bikash Lama", 9805567890L, "bikash.lama@email.com",
				new Address("Bharatpur Avenue", "Bharatpur", 44200)
		);

		List<Student> students = List.of(student1, student2, student3, student4, student5);
		studentRepository.saveAll(students);

		// Get All Students
		studentRepository.findAll().forEach(System.out::println);

		// Get All Students with certain name
		studentRepository.findByName("Anil Shrestha").forEach(System.out::println);
		// Get a student by phoneNumber
		System.out.println(studentRepository.findByPhoneNumber(9805567890L));
		// Get All Students in same city
		studentRepository.findByCity("Kathmandu").forEach(System.out::println);

	}

}
