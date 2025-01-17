package org.example;


import com.github.javafaker.Faker;

import java.util.*;

public class Archivio {

    public static Faker fake=new Faker(new Locale("it"));
    public static Scanner sc= new Scanner(System.in);

   private static Map<Pubblicazioni, Long> listaPubblicazioni=new HashMap<Pubblicazioni, Long>();


    public static void main(String[] args){

        creazioneArchivio();
        creazioneArchivio().forEach(((pubblicazioni, i) ->
                System.out.println(pubblicazioni.toString())));

        aggiungiLibri(21);
        ricercaPub(2);


    }

   public static   Map<Pubblicazioni,Long> creazioneArchivio() {
       for (int i = 0; i < 10; i++) {

           Pubblicazioni p = new Libri(i+1, fake.book().title(), fake.number()
                   .numberBetween(1890, 2023), fake.number().numberBetween(40, 3500), fake.book()
                   .author(), fake.book().genre());
           listaPubblicazioni.put(p, p.ISBN);

       }
       Pubblicazioni r1 = new Riviste(11, "ELLE DECOR", fake.number().numberBetween(1920, 2020),
               fake.number().numberBetween(20, 150), Periodicita.SETTIMANALE);
       Pubblicazioni r2 = new Riviste(12, "MARIE CLAIRE", fake.number().numberBetween(1920, 2020),
               fake.number().numberBetween(20, 150), Periodicita.MENSILE);
       Pubblicazioni r3 = new Riviste(13, "Focus italia", fake.number().numberBetween(1920, 2020),
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
       listaPubblicazioni.put(r1, r1.ISBN);
       listaPubblicazioni.put(r2, r2.ISBN);
       listaPubblicazioni.put(r3, r3.ISBN);
       listaPubblicazioni.put(r4, r4.ISBN);
       listaPubblicazioni.put(r5, r5.ISBN);
       listaPubblicazioni.put(r6, r6.ISBN);
       listaPubblicazioni.put(r7, r7.ISBN);
       listaPubblicazioni.put(r8, r8.ISBN);
       listaPubblicazioni.put(r9, r9.ISBN);
       listaPubblicazioni.put(r10, r10.ISBN);
       return listaPubblicazioni;
   }


public static void aggiungiLibri(long i){

Libri l=new Libri(i,fake.book().title(),fake.number().numberBetween(1950,2022),fake.number()
        .numberBetween(49,5000),fake.book().author(),fake.book().genre());
listaPubblicazioni.put(l,i);
    System.out.println("LIBRO AGGIUNTO: " + l);

}
    public static void aggiungiRivista(long i,String titolo, int p){

        if(p==1){
        Riviste r =new Riviste(i,titolo,fake.number().numberBetween(1950,2022),fake.number()
                .numberBetween(49,5000),Periodicita.SETTIMANALE);
        listaPubblicazioni.put(r,i);
        System.out.println("RIVISTA AGGIUNTA: " + r);
        } else if (p==2) {
            Riviste r =new Riviste(i,titolo,fake.number().numberBetween(1950,2022),fake.number()
                    .numberBetween(49,5000),Periodicita.MENSILE);
            listaPubblicazioni.put(r,i);
            System.out.println("RIVISTA AGGIUNTA: " + r);
        } else if (p==3) {
            Riviste r =new Riviste(i,titolo,fake.number().numberBetween(1950,2022),fake.number()
                    .numberBetween(49,5000),Periodicita.ANNUALE);
            listaPubblicazioni.put(r,i);
            System.out.println("RIVISTA AGGIUNTA: " + r);

        }

    }


    public static void ricercaPub(long i) {
        Pubblicazioni pub = null;
        for (Pubblicazioni p : listaPubblicazioni.keySet()) {
            if (i == p.ISBN) {
                pub = p;
                break;
            }
        }
            if (pub != null) {
                System.out.println(pub);
            } else {
                System.out.println("pubblicazione inesistente");
            }

        }


    }
