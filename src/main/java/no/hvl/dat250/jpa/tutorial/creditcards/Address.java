package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getStreet() {
        return null;
    }

    public Integer getNumber() {
        return null;
    }

    public Collection<Customer> getOwners() {
        // TODO: implement method!
        return null;
    }
}
