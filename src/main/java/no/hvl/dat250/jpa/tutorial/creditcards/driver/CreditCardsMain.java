package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // TODO: Create object world as shown in the README.md.
    //Opprett kunde
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    //Lagre kunden
    em.persist(customer);

    //Opprett adresse
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    //Lagre adresse
    em.persist(address);

    // Knytt adressen til kunden
    customer.addAddress(address);

    // Opprett PIN-kode
    Pincode pincode = new Pincode();
    pincode.setPincode("123");
    pincode.setCount(1);
    em.persist(pincode); // Lagre PIN-koden

    // Opprett bank
    Bank bank = new Bank();
    bank.setName("Pengebank");
    em.persist(bank); // Lagre banken

    // Opprett kredittkort med PIN-koden
    CreditCard firstCard = new CreditCard();
    firstCard.setNumber(12345);
    firstCard.setBalance(-5000);
    firstCard.setCreditLimit(-10000);
    firstCard.setPincode(pincode); // Knytt PIN-koden til kredittkortet
    firstCard.setOwningBank(bank);
    em.persist(firstCard);

    CreditCard secondCard = new CreditCard();
    secondCard.setNumber(123);
    secondCard.setBalance(1);
    secondCard.setCreditLimit(2000);
    secondCard.setPincode(pincode); // Sett samme PIN-kode som første kort
    secondCard.setOwningBank(bank);
    em.persist(secondCard);

    // Knytt kredittkortene til kunden
    customer.getCreditCards().add(firstCard);
    customer.getCreditCards().add(secondCard);

    // Knytt kredittkortene til banken
    bank.getOwnedCards().add(firstCard);
    bank.getOwnedCards().add(secondCard);

  }
}
