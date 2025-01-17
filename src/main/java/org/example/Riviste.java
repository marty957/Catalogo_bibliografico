package org.example;

public class Riviste extends Pubblicazioni {

Periodicita periodicita;

    public Riviste(long ISBN, String titolo, long annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(ISBN, titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }
}
