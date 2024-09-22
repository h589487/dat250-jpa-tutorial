package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> customers = new HashSet<>();


    public String getStreet() {
        return this.street;
    }

    public Integer getNumber() {

        return this.number;
    }

    public Set<Customer> getOwners() {
        // TODO: implement method!
        return this.customers;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Setter for owners
    public void setOwners(Set<Customer> customers) {
        this.customers = customers;
    }


}
