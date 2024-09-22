package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank")
    @OrderBy("number ASC")
    private Set<CreditCard> creditCards = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Set<CreditCard> getOwnedCards() { // Endret til List
        return this.creditCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}



