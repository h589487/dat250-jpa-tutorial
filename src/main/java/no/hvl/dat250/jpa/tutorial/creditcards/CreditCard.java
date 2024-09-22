package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.util.Collection;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;
    @ManyToOne
    private Pincode pincode;

    @ManyToOne
   private Bank bank;

    public Integer getNumber() {
        return this.number;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return this.bank;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public void setOwningBank(Bank bank) {
        this.bank = bank;
    }

}
