package org.fasttrackit.healthcareapp.transfer.appointment;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

public class SaveAppointmentRequest {

    @NotNull
    private long personcnp;

    private Date data;
    private Time ora;
    private String observatie;

    public long getPersoncnp() {
        return personcnp;
    }

    public void setPersoncnp(long personcnp) {
        this.personcnp = personcnp;
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
        return "SaveAppointmentRequest{" +
                "personcnp=" + personcnp +
                ", data=" + data +
                ", ora=" + ora +
                ", observatie='" + observatie + '\'' +
                '}';
    }
}
