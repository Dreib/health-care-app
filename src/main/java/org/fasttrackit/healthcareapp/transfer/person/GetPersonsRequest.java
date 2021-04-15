package org.fasttrackit.healthcareapp.transfer.person;

public class GetPersonsRequest {

    private String nume;
    private String prenume;
    private String judet;
    private String localitate;
    private String strada;
    private String tip;

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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "GetPersonsRequest{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", judet='" + judet + '\'' +
                ", localitate='" + localitate + '\'' +
                ", strada='" + strada + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }
}
