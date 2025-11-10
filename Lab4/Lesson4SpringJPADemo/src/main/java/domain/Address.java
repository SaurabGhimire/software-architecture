package domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    private int zip;


    public Address(){}

    public Address(String street, String city, int zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
}


