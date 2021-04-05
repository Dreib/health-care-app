package org.fasttrackit.healthcareapp.transfer.person;

import javax.validation.constraints.NotNull;

public class SavePersonRequest {

    @NotNull
    private int cnp;
    @NotNull
    private String nume;
    @NotNull
    private String prenume;

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
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

    @Override
    public String toString() {
        return "SavePersonRequest{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
