package org.fasttrackit.healthcareapp.transfer.appointment;

import java.sql.Date;

public class AppointmentTypeCcm {

    private long ccm_id;
    private String serie;
    private int numar;
    private Date v_date_start;
    private Date v_date_end;
    private long cnp;

    public long getCcm_id() {
        return ccm_id;
    }

    public void setCcm_id(long ccm_id) {
        this.ccm_id = ccm_id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public Date getV_date_start() {
        return v_date_start;
    }

    public void setV_date_start(Date v_date_start) {
        this.v_date_start = v_date_start;
    }

    public Date getV_date_end() {
        return v_date_end;
    }

    public void setV_date_end(Date v_date_end) {
        this.v_date_end = v_date_end;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "AppointmentTypeCcm{" +
                "ccm_id=" + ccm_id +
                ", serie='" + serie + '\'' +
                ", numar=" + numar +
                ", v_date_start=" + v_date_start +
                ", v_date_end=" + v_date_end +
                ", cnp=" + cnp +
                '}';
    }
}
