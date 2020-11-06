package org.fasttrackit.healthcareapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
