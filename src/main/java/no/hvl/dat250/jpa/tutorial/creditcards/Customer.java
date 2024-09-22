package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    private Set<CreditCard> creditCards = new HashSet<>();



    public String getName() {
        // TODO: implement method!
        return this.name;
    }

    public Set<Address> getAddresses() {
        // TODO: implement method!
        return this.addresses;
    }

    public Set<CreditCard> getCreditCards() {
        // TODO: implement method!
        return this.creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(Set<Address> addresses) {
        if (addresses != null) {
            this.addresses = addresses;
        }
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        if (creditCards != null) {
            this.creditCards = creditCards;
        }
    }

    public void addAddress(Address address) {
        if (address != null && !this.addresses.contains(address)) {
            this.addresses.add(address); // Legg til adressen i kundens liste
            address.getOwners().add(this); // Legg til kunden i adressens liste
        }
    }



}
