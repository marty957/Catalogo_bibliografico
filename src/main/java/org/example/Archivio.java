package org.example;


import com.github.javafaker.Faker;

import java.nio.file.FileAlreadyExistsException;
import java.util.*;
import java.util.stream.Collectors;

public class Archivio {

    public static Faker fake = new Faker(new Locale("it"));
    public static Scanner sc = new Scanner(System.in);

    private static Map<Long,Pubblicazioni> listaPubblicazioni = new HashMap<>();


    public static void main(String[] args) throws Exception {

        creazioneArchivio();

        System.out.println("Cosa vuoi fare?");
        System.out.println("digita 1 per aggiungere un libro");
        System.out.println("digita 2 per aggiungere un Rivista");
        System.out.println("digita 3 per ricercare una Pubblicazione");
        System.out.println("digita 4 per eliminiare una pubblicazione");
        System.out.println("digita 5 per ricercare  tramite anno di pubblicazione ");
        System.out.println("digita 6 per ricercare un autore ");
        System.out.println("digita 7 per modificare una pubblicazione ");
        System.out.println("digita 8 per visualizzare le statistiche");
        System.out.println("digita 0 terminare");

        int azioneScelta= sc.nextInt();
        sc.nextLine();
        switch (azioneScelta) {
            case 0:
                System.out.println("programma terminato");
                break;
            case 1:
                System.out.println("inserisci il codice ibsn del nuovo Libro: ");
                long i=sc.nextLong();
                sc.nextLine();
                aggiungiLibri(i);
                break;
            case 2:
                aggiungiRivista(22, "la stagione calcistica", 2);
                break;
            case 3:
                try {
                    System.out.println("inserisci il codice ibsn della pubblicazione che desideri cercare");
                    long num=sc.nextLong();
                    sc.nextLine();
                ricercaPub(num);}
                catch (Exception e){
                    System.out.println("Errore di inserimento" + e.getMessage());
                }
                break;
            case 4:
                try {
                    System.out.println("inserisci il codice ibsn della pubblicazione che vuoi eliminare");
                    long num=sc.nextLong();
                    sc.nextLine();
                    eliminaPub(num);
                }catch (NumberFormatException e){
                    System.out.println("devi inserire un numero" + e.getMessage());
                }
                break;
            case 5:
                try {
                    System.out.println("inserisci l'anno di pubblicazion");
                    long anno=sc.nextLong();
                    sc.nextLine();
                ricercaAnnoPub(anno);}
                catch (NumberFormatException e){
                    System.out.println("non hai inserito un numero" + e.getMessage());
                }
                break;
            case 6:
                try {
                    System.out.println("inserisci l'autore che vuoi ricercare");
                    String autore=sc.nextLine();
                ricercaAutore(autore);
                }
                catch (Exception e){
                    System.out.println("errore di inserimento" + e.getMessage());
                }
                break;
            case 7:
                System.out.println("Fornisci Ibsn della pubblicazione da modificare");
                long ibsn=sc.nextLong();
                sc.nextLine();
                modifica(ibsn);
                break;
            case 8:
                statistiche();
                break;

            default:
                throw new Exception("selezione invalida");

        }


    }

    public static Map<Long,Pubblicazioni> creazioneArchivio() {
        for (int i = 0; i < 10; i++) {
            Pubblicazioni p = new Libri(i + 1, fake.book().title(), fake.number()
                    .numberBetween(1890, 2023), fake.number().numberBetween(40, 3500), fake.book()
                    .author(), fake.book().genre());
            listaPubblicazioni.put(p.ISBN,p);
        }

        Pubblicazioni r1 = new Riviste(11, "ELLE DECOR", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.SETTIMANALE);
        Pubblicazioni r2 = new Riviste(12, "MARIE CLAIRE", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.MENSILE);
        Pubblicazioni r3 = new Riviste(13, "Focus italia", 1950,
                fake.number().numberBetween(20, 150), Periodicita.SETTIMANALE);
        Pubblicazioni r4 = new Riviste(14, "ELLE", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.MENSILE);
        Pubblicazioni r5 = new Riviste(15, "Icon", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.MENSILE);
        Pubblicazioni r6 = new Riviste(16, "Forbes", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.SETTIMANALE);
        Pubblicazioni r7 = new Riviste(17, "Chi", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.SETTIMANALE);
        Pubblicazioni r8 = new Riviste(18, "Guinness World Records", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.ANNUALE);
        Pubblicazioni r9 = new Riviste(19, "Scoperte scentifiche dell'anno", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.ANNUALE);
        Pubblicazioni r10 = new Riviste(20, "National Geographic Magazine", fake.number().numberBetween(1920, 2020),
                fake.number().numberBetween(20, 150), Periodicita.MENSILE);
        listaPubblicazioni.put( r1.ISBN,r1);
        listaPubblicazioni.put(r2.ISBN,r1);
        listaPubblicazioni.put( r3.ISBN,r3);
        listaPubblicazioni.put(r4.ISBN,r4);
        listaPubblicazioni.put(r5.ISBN,r5);
        listaPubblicazioni.put(r6.ISBN,r6);
        listaPubblicazioni.put(r7.ISBN,r7);
        listaPubblicazioni.put(r8.ISBN,r8);
        listaPubblicazioni.put(r9.ISBN,r9);
        listaPubblicazioni.put(r10.ISBN,r10);


        return listaPubblicazioni;
    }


    public static void aggiungiLibri(long i) throws FileAlreadyExistsException {

        if(!listaPubblicazioni.containsKey(i)) {

            Libri l = new Libri(i, fake.book().title(), fake.number().numberBetween(1950, 2022), fake.number()
                    .numberBetween(49, 5000), fake.book().author(), fake.book().genre());
            listaPubblicazioni.put(i, l);
            System.out.println("LIBRO AGGIUNTO: " + l);
        }
        else {
            throw new FileAlreadyExistsException("ibsn gia presente in archivio");
        }


    }

    public static void aggiungiRivista(long i, String titolo, int p) {

        if (p == 1) {
            Riviste r = new Riviste(i, titolo, fake.number().numberBetween(1950, 2022), fake.number()
                    .numberBetween(49, 5000), Periodicita.SETTIMANALE);
            listaPubblicazioni.put( i,r);
            System.out.println("RIVISTA AGGIUNTA: " + r);
        } else if (p == 2) {
            Riviste r = new Riviste(i, titolo, fake.number().numberBetween(1950, 2022), fake.number()
                    .numberBetween(49, 5000), Periodicita.MENSILE);
            listaPubblicazioni.put(i,r);
            System.out.println("RIVISTA AGGIUNTA: " + r);
        } else if (p == 3) {
            Riviste r = new Riviste(i, titolo, fake.number().numberBetween(1950, 2022), fake.number()
                    .numberBetween(49, 5000), Periodicita.ANNUALE);
            listaPubblicazioni.put(i,r);
            System.out.println("RIVISTA AGGIUNTA: " + r);

        }

    }

    public static void ricercaPub(long i) throws IsbnInesitente {

        if(listaPubblicazioni.containsKey(i)){
            System.out.println("PUBBLICAZIONE RICERCATA: "+ listaPubblicazioni.get(i));
        }
        else {
            throw new IsbnInesitente("Codice ISBN non valido. Pubblicazione inesistente");
        }
        }

        public static void eliminaPub(long i){
            System.out.println( "pubblicazione eliminata: " + listaPubblicazioni.get(i));
        listaPubblicazioni.remove(i);
        }

        public static List<Pubblicazioni> ricercaAnnoPub(long anno){

        List<Pubblicazioni> ricercaPerAnno=new ArrayList<>(listaPubblicazioni.values());
        ricercaPerAnno.stream().filter(pub -> anno== pub.annoPubblicazione )
                .forEach(ele-> System.out.println("Pubblicazioni ricercate: "+ele));

        return ricercaPerAnno;

        }
    public static List<Pubblicazioni> ricercaAutore(String autore){

        List<Pubblicazioni> ricercaPerAnno=new ArrayList<>(listaPubblicazioni.values());
        ricercaPerAnno.stream().filter(pub -> pub instanceof Libri).filter(l->autore.equals(((Libri) l).getAutore()))
                .forEach(ele-> System.out.println("Pubblicazioni ricercate: "+ele));

        return ricercaPerAnno;

    }

    public static void modifica(long ibsn) throws IsbnInesitente {

        List<Pubblicazioni> elementoModificato= new ArrayList<>(listaPubblicazioni.values());

        for(Pubblicazioni pub:elementoModificato) {
            if (pub.ISBN == ibsn) {
                System.out.println("cosa vuoi aggiornare? digita 1 pe il titolo, 2 per l'anno di pubblicazione");

                int scelta = sc.nextInt();

                if (scelta == 1) {
                    System.out.println("scrivi il nuovo titolo: ");
                    String tit = sc.nextLine();
                    pub.setTitolo(tit);
                    System.out.println(pub);

                } else if (scelta == 2) {
                    System.out.println("scrivi il nuovo anno di pubblicazione: ");
                    long anno = sc.nextLong();
                    pub.setAnnoPubblicazione(anno);
                    System.out.println(pub);


                } else {
                    throw new IsbnInesitente("codice ibsn non valido");
                }
            }



        }
    }
    public static void statistiche(){

        List<Pubblicazioni> statistiche= new ArrayList<>(listaPubblicazioni.values());

        long numeroLibri=statistiche.stream().filter(pub->pub instanceof Libri).count();
        long numeroRiviste=statistiche.stream().filter(pub->pub instanceof Riviste).count();

      List <Pubblicazioni> p= statistiche.stream().sorted(Comparator.comparing(Pubblicazioni::getNumPagine).reversed()).limit(1).toList();

       double numPagineMedie= statistiche.stream().mapToDouble(Pubblicazioni::getNumPagine).average().orElse(0.0);

        System.out.println("In archivio sono presenti: " +numeroLibri+ " Libri.");
        System.out.println("In archivio sono presenti: " +numeroRiviste+ " Riviste.");
        System.out.println("La pubblicazione con il maggior numero di pagine e: " + p);
        System.out.println("il numero medio delle pagine delle Pubblicazioni presenti in archivio è: " + numPagineMedie);

    }
}










