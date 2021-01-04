package se.lexicon.model;

import java.util.Objects;

public class Address {

    private String street;
    private String zipcode;
    private String city;

    public Address(String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode()) && Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getZipcode(), getCity());
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
