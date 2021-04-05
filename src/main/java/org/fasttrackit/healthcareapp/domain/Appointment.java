package org.fasttrackit.healthcareapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "programari")
public class Appointment implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_cnp")
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
        return "Appointment{" +
                "id=" + id +
                ", cnp=" + person_cnp +
                ", data=" + data +
                ", ora=" + ora +
                ", observatie='" + observatie + '\'' +
                '}';
    }

}
