package org.fasttrackit.healthcareapp.transfer.appointment;

import org.fasttrackit.healthcareapp.domain.Person;

import java.sql.Date;
import java.sql.Time;

public class AppointmentResponse {

    private long id;
    private Person person_cnp;
    private Date data;
    private Time ora;
    private String observatie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson_cnp() {
        return person_cnp;
    }

    public void setPerson_cnp(Person person_cnp) {
        this.person_cnp = person_cnp;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getOra() {
        return ora;
    }

    public void setOra(Time ora) {
        this.ora = ora;
    }

    public String getObservatie() {
        return observatie;
    }

    public void setObservatie(String observatie) {
        this.observatie = observatie;
    }

    @Override
    public String toString() {
        return "AppointmentResponse{" +
                "id=" + id +
                ", person_cnp=" + person_cnp +
                ", data=" + data +
                ", ora=" + ora +
                ", observatie='" + observatie + '\'' +
                '}';
    }
}
