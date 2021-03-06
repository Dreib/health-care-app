package org.fasttrackit.healthcareapp.transfer.person;

import javax.validation.constraints.NotNull;

public class SavePersonRequest {

    @NotNull
    private long cnp;
    @NotNull
    private String nume;
    @NotNull
    private String prenume;
    private String judet;
    private String localitate;
    private String strada;
    private int numar;
    private String bloc;
    private int etaj;
    private int apartament;
    @NotNull
    private String tip;

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
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

    @Override
    public String toString() {
        return "SavePersonRequest{" +
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
}
