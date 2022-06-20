package com.example.crud.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state_of_province")
    private String stateOfProvince;

    @Column(name = "country")
    private String country;

    @Column(name = "postalCode")
    private String postalCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOfProvince() {
        return stateOfProvince;
    }

    public void setStateOfProvince(String stateOfProvince) {
        this.stateOfProvince = stateOfProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(address, group.address) && Objects.equals(city, group.city) && Objects.equals(stateOfProvince, group.stateOfProvince) && Objects.equals(country, group.country) && Objects.equals(postalCode, group.postalCode) && Objects.equals(user, group.user) && Objects.equals(events, group.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, city, stateOfProvince, country, postalCode, user, events);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", stateOfProvince='" + stateOfProvince + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", user=" + user +
                ", events=" + events +
                '}';
    }
}
