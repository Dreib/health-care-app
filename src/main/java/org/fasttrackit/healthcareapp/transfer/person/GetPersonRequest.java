package org.fasttrackit.healthcareapp.transfer.person;

public class GetPersonRequest {

    private String numePartial;
    private String prenumePartial;

    public String getNumePartial() {
        return numePartial;
    }

    public void setNumePartial(String numePartial) {
        this.numePartial = numePartial;
    }

    public String getPrenumePartial() {
        return prenumePartial;
    }

    public void setPrenumePartial(String prenumePartial) {
        this.prenumePartial = prenumePartial;
    }

    @Override
    public String toString() {
        return "GetPersonRequest{" +
                "numePartial='" + numePartial + '\'' +
                ", prenumePartial='" + prenumePartial + '\'' +
                '}';
    }
}
