package org.example;

public class Libri extends Pubblicazioni {

    private String autore;
    private String genere;


    public Libri(long ISBN, String titolo, long annoPubblicazione, int numPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere= genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }
}
