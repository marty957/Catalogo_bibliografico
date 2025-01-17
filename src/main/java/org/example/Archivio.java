package org.example;


import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Archivio {

    public static Faker fake = new Faker(new Locale("it"));
    public static Scanner sc = new Scanner(System.in);

    private static Map<Long,Pubblicazioni> listaPubblicazioni = new HashMap<Long,Pubblicazioni>();


    public static void main(String[] args) throws IsbnInesitente {

        creazioneArchivio().forEach(((i, pubblicazioni) ->
                System.out.println(pubblicazioni.toString())));

        aggiungiLibri(21);
        aggiungiRivista(22,"la stagione calcistica",2);
        ricercaPub(2);
        eliminaPub(21);
        ricercaAnnoPub(1950);





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


    public static void aggiungiLibri(long i) {

        Libri l = new Libri(i, fake.book().title(), fake.number().numberBetween(1950, 2022), fake.number()
                .numberBetween(49, 5000), fake.book().author(), fake.book().genre());
        listaPubblicazioni.put( i,l);
        System.out.println("LIBRO AGGIUNTO: " + l);

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

        List<Pubblicazioni> ricercaPerAnno=new ArrayList<Pubblicazioni>(listaPubblicazioni.values());
        ricercaPerAnno.stream().filter(pub -> anno== pub.annoPubblicazione )
                .forEach(ele-> System.out.println("Pubblicazioni ricercate: "+ele));

        return ricercaPerAnno;

        };
    public static List<Libri> ricercaAutore(String autore){

        List<Libri> ricercaPerAnno=new ArrayList<Libri>(listaPubblicazioni.values(<Libri>));
        ricercaPerAnno.stream().filter(pub -> autore.equals(pub.get) )
                .forEach(ele-> System.out.println("Pubblicazioni ricercate: "+ele));

        return ricercaPerAnno;

    };

    }







