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

    private long cnp;

    private Date data_trimitere;
    private String judet;
    private String localitate;
    private String unitate_sanitara;
    private String catre;
    private String diagnostic_prezumtiv;
    private String motivul_trimiterii;
    private String investigatii_tratamente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData_trimitere() {
        return data_trimitere;
    }

    public void setData_trimitere(Date data_trimitere) {
        this.data_trimitere = data_trimitere;
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

    public String getUnitate_sanitara() {
        return unitate_sanitara;
    }

    public void setUnitate_sanitara(String unitate_sanitara) {
        this.unitate_sanitara = unitate_sanitara;
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

    public String getDiagnostic_prezumtiv() {
        return diagnostic_prezumtiv;
    }

    public void setDiagnostic_prezumtiv(String diagnostic_prezumtiv) {
        this.diagnostic_prezumtiv = diagnostic_prezumtiv;
    }

    public String getMotivul_trimiterii() {
        return motivul_trimiterii;
    }

    public void setMotivul_trimiterii(String motivul_trimiterii) {
        this.motivul_trimiterii = motivul_trimiterii;
    }

    public String getInvestigatii_tratamente() {
        return investigatii_tratamente;
    }

    public void setInvestigatii_tratamente(String investigatii_tratamente) {
        this.investigatii_tratamente = investigatii_tratamente;
    }

    @Override
    public String toString() {
        return "BT{" +
                "id=" + id +
                ", data_trimitere=" + data_trimitere +
                ", judet='" + judet + '\'' +
                ", localitate='" + localitate + '\'' +
                ", unitate_sanitara='" + unitate_sanitara + '\'' +
                ", cnp=" + cnp +
                ", catre='" + catre + '\'' +
                ", diagnostic_prezumtiv='" + diagnostic_prezumtiv + '\'' +
                ", motivul_trimiterii='" + motivul_trimiterii + '\'' +
                ", investigatii_tratamente='" + investigatii_tratamente + '\'' +
                '}';
    }
}
