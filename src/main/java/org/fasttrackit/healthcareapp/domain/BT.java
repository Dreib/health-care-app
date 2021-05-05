package org.fasttrackit.healthcareapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "bt")
public class BT {

    @Id
    @GeneratedValue
    private long id;

    private Date trimitere;
    private String judet;
    private String localitate;
    private String unitate;
    private long cnp;
    private String catre;
    private String diagnostic;
    private String motiv;
    private String investigatii;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTrimitere() {
        return trimitere;
    }

    public void setTrimitere(Date trimitere) {
        this.trimitere = trimitere;
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

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public String getCatre() {
        return catre;
    }

    public void setCatre(String catre) {
        this.catre = catre;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getMotiv() {
        return motiv;
    }

    public void setMotiv(String motiv) {
        this.motiv = motiv;
    }

    public String getInvestigatii() {
        return investigatii;
    }

    public void setInvestigatii(String investigatii) {
        this.investigatii = investigatii;
    }

    @Override
    public String toString() {
        return "BT{" +
                "id=" + id +
                ", trimitere=" + trimitere +
                ", judet='" + judet + '\'' +
                ", localitate='" + localitate + '\'' +
                ", unitate='" + unitate + '\'' +
                ", cnp=" + cnp +
                ", catre='" + catre + '\'' +
                ", diagnostic='" + diagnostic + '\'' +
                ", motiv='" + motiv + '\'' +
                ", investigatii='" + investigatii + '\'' +
                '}';
    }
}
