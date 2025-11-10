package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long phoneNumber;
    private  String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Student(){}

    public Student(String name, long phoneNumber, String email, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
