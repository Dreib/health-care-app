package org.fasttrackit.healthcareapp.transfer.appointment;

import org.fasttrackit.healthcareapp.domain.Person;

import java.sql.Date;
import java.sql.Time;

public class GetAppointmentRequest {

    private Person person_cnp;
    private Date data;
    private Time ora;

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

    @Override
    public String toString() {
        return "GetAppointmentRequest{" +
                "data=" + data +
                ", ora=" + ora +
                '}';
    }
}
