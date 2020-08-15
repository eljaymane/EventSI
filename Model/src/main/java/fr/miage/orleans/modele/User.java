package fr.miage.orleans.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @ManyToOne() @JoinColumn(name = "countryId", referencedColumnName = "id")
    private Country country;
    private String firstName;
    private String lastName;
    @Pattern(regexp="(^$|[0-9]{10})")
    @NotBlank
    private String phoneNumber;
    @OneToOne()
    @JoinColumn(name ="id", referencedColumnName = "rankId")
    private Rank rank;


    public User() {
    }

    public User(long id, String username, Country country, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User id(long id) {
        this.id = id;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User country(Country country) {
        this.country = country;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public User(long id, String username, Country country, String firstName, String lastName, String phoneNumber, Rank rank) {
        this.id = id;
        this.username = username;
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public User rank(Rank rank) {
        this.rank = rank;
        return this;
    }



    

    
}