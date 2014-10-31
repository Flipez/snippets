package Weizen_calc;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.text.NumberFormat;

 

public class weizen

{

 

     public static void main(String[] args) throws IOException

     {

          // notwendige Variablen:

          BufferedReader In = new BufferedReader(new InputStreamReader(System.in));

          double körner = 0.0;

          double masse, länge, waggon;

          int felder;

          String abfrage;

          /*

           * Damit das ausgegebene Ergebnis besser lesbar wird, erfolgt eine Zahlenformatieung.

           * Dafür wird die Klasse NumberFormat verwendet.

           * Dem Objekt der Klasse, ausgabeFormat, wir die deutsche Standardformatierung übergeben.  

           */

          NumberFormat ausgabeFormat = NumberFormat.getInstance();

          //Festlegung der max. Anzahl an Nachkommastellen

          ausgabeFormat.setMaximumFractionDigits(0);

          System.out.println("Programm zur Berechnung der Weizenkörner nach Sessa!");

          // ----------------------------Standardberechnung------------------------------------------

          System.out

                     .println("Bei Belegung aller 64 Schachfelder ergeben sich die folgenden Werte:");

          for (int i = 0; i <= 63; i++)

          {

                /*

                 * Die Methode "pow" aus der Math-class potenzier den double - Wert 2 mit

                 * der Schachfeldnummer. Beispiel: erstes Schachfeld - Nummer 0 - 2^0 = 1,

                 * zweites Schachfeld - Nummer 1 - 2^1 = 2, ...

                 */

                körner = körner + Math.pow(2.0, (double) i);

          }

          System.out.println("Die Gesamtzahl der Körner beträgt " + ausgabeFormat.format(körner)

                     + " Stück!");

          masse = (körner / 200) / 1000 / 1000; // Masse in Tonnen

          System.out.println("\tDie Masse Beträgt " + ausgabeFormat.format(masse) + " t!");

          waggon = masse / 30;

          System.out.println(ausgabeFormat.format(waggon)

                     + " Waggons werden für den Transport benötigt!");

          länge = waggon * 15 / 1000; // Länge in km

          System.out.println("\tDies würde zu einer Länge von " + ausgabeFormat.format(länge)

                     + " km führen!");

          // Zurücksetzen des Variablenwertes auf 0

          körner = 0;

          // ----------------------------Zwischenwertberechnung-------------------------------------------

          System.out.println("Berechnung von Zwischenergebnissen:");

          System.out.println("Wieviel Schachfelder sollen belegt werden?");

          do

          {

                System.out.print("Geben Sie die gewünschte Anzahl ein: ");

                felder = Integer.parseInt(In.readLine());

                //Überprüfung, ob auch eine richtige Schachfeldnummer eingegeben wurde

                if ((felder < 0) || (felder > 64))

                {

                     System.out.println("Sie müssen eine gültige Zahal eingeben!");

                }

                while ((felder > 0) && (felder <= 64))

                {

                     for (int i = 0; i <= (felder - 1); i++)

                     {

                          körner = körner + Math.pow(2.0, (double) i);

                     }

                     System.out.println("Die Gesamtzahl der Körner beträgt " + ausgabeFormat.format(körner)

                               + " Stück!");

                     masse = (körner / 200) / 1000 / 1000; // Masse in Tonnen

                     System.out.println("\tDie Masse Beträgt " + ausgabeFormat.format(masse) + " t!");

                     waggon = masse / 30;

                     if (waggon < 1 || waggon == 1)

                     {

                          waggon = 1;

                          System.out.println(ausgabeFormat.format(waggon)

                                     + " Waggon wird für den Transport benötigt!");

                          System.out.println("\tDies würde zu einer Länge von 15 m führen!");

                     } else

                     {

                          System.out.println(ausgabeFormat.format(waggon)

                                     + " Waggons werden für den Transport benötigt!");

                          länge = waggon * 15 / 1000; // Länge in km

                          System.out.println("\tDies würde zu einer Länge von " + ausgabeFormat.format(länge)

                                     + " km führen!");

                     }

                     körner = 0;

                     break;

                } // end of while

                System.out.print("Neuberechnung? j/n: ");

                abfrage = In.readLine();

          } // end of do

          while (abfrage.equalsIgnoreCase("J"));

          System.out.println("Das Programm wurde beendet!");

     }// end of main

}// end of class

