package edu.mum.week1ExtraCredit.domain;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Basic(optional = false)
    private String state;
    @Basic(optional = false)
    private String city;
    @Basic(optional = false)
    private Integer zip;
    @Basic(optional = false)
    private String street;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
