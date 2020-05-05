package entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    public String street;
    public String city;
    public String country;

    public Address() {
    }

    public Address(String street, String city, String country) {
        street = street;
        city = city;
        country = country;
    }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }


    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }


    public String getCountry(){return this.country;}
    public void setCountry(String country){this.country = country;}
}
