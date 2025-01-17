package org.example;

public class Pubblicazioni {

    protected long ISBN;
    protected String titolo;
    protected long annoPubblicazione;
    protected int numPagine;

    public Pubblicazioni(long ISBN, String titolo, long annoPubblicazione, int numPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public long getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnnoPubblicazione(long annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    public int getNumPagine() {
        return numPagine;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }
}
