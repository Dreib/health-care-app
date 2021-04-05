package org.fasttrackit.healthcareapp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persoana")
public class Person implements Serializable {

    @Id
    private int cnp;

    private String nume;
    private String prenume;
    private String judet;
    private String localitate;
    private String strada;
    private int numar;
    private String bloc;
    private int etaj;
    private int apartament;
    private String tip;

    @OneToMany(mappedBy = "person_cnp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getBloc() {
        return bloc;
    }

    public void setBloc(String bloc) {
        this.bloc = bloc;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public int getApartament() {
        return apartament;
    }

    public void setApartament(int apartament) {
        this.apartament = apartament;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp=" + cnp +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", judet='" + judet + '\'' +
                ", localitate='" + localitate + '\'' +
                ", strada='" + strada + '\'' +
                ", numar=" + numar +
                ", bloc='" + bloc + '\'' +
                ", etaj=" + etaj +
                ", apartament=" + apartament +
                ", tip='" + tip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (cnp != person.cnp) return false;
        if (numar != person.numar) return false;
        if (etaj != person.etaj) return false;
        if (apartament != person.apartament) return false;
        if (nume != null ? !nume.equals(person.nume) : person.nume != null) return false;
        if (prenume != null ? !prenume.equals(person.prenume) : person.prenume != null) return false;
        if (judet != null ? !judet.equals(person.judet) : person.judet != null) return false;
        if (localitate != null ? !localitate.equals(person.localitate) : person.localitate != null) return false;
        if (strada != null ? !strada.equals(person.strada) : person.strada != null) return false;
        if (bloc != null ? !bloc.equals(person.bloc) : person.bloc != null) return false;
        if (tip != null ? !tip.equals(person.tip) : person.tip != null) return false;
        return appointments != null ? appointments.equals(person.appointments) : person.appointments == null;
    }

    @Override
    public int hashCode() {
        int result = cnp;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (judet != null ? judet.hashCode() : 0);
        result = 31 * result + (localitate != null ? localitate.hashCode() : 0);
        result = 31 * result + (strada != null ? strada.hashCode() : 0);
        result = 31 * result + numar;
        result = 31 * result + (bloc != null ? bloc.hashCode() : 0);
        result = 31 * result + etaj;
        result = 31 * result + apartament;
        result = 31 * result + (tip != null ? tip.hashCode() : 0);
        result = 31 * result + (appointments != null ? appointments.hashCode() : 0);
        return result;
    }
}
