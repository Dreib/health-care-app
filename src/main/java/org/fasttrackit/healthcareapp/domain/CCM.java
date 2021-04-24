package org.fasttrackit.healthcareapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ccm")
public class CCM {

    @Id
    @GeneratedValue
    private long id;

    private long cnp;

    private String serie;
    private String numar;
    private Date v_date_start;
    private Date v_date_end;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
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

    @Override
    public String toString() {
        return "CCM{" +
                "ccm_id=" + id +
                ", cnp=" + cnp +
                ", serie='" + serie + '\'' +
                ", numar='" + numar + '\'' +
                ", v_date_start=" + v_date_start +
                ", v_date_end=" + v_date_end +
                '}';
    }
}
