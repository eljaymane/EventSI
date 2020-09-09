package fr.miage.orleans.modele;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String countryName;
    //@Pattern(regexp="(^$|[0-9]{3})")
    private String phoneCode;


    public Country() {
    }

    public Country(long id, String countryName, String phoneCode) {
        this.id = id;
        this.countryName = countryName;
        this.phoneCode = phoneCode;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhoneCode() {
        return this.phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Country id(long id) {
        this.id = id;
        return this;
    }

    public Country countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public Country phoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
        return this;
    }


}
