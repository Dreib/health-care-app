package org.fasttrackit.healthcareapp.transfer.appointment;

import java.sql.Date;
import java.sql.Time;

public class GetAppointmentRequest {

    private Date data;
    private Time ora;

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
