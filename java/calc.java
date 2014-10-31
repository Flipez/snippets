package Weizen_calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calc
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		// Erste Textausgabe bei Start
		System.out.println("Programm zur Ausgabe von ungeraden, natürlichen Zahlen.");
			
		//Deklarierung bzw. Initialisierung der Verarbeitungsvariablen
		int zahl;
		
	//Verarbeitung der Tastatureingabe:
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  System.out.print("Geben Sie eine beliebige ganze Zahl ein: ");
			zahl = Integer.parseInt(br.readLine());
			System.out.println("Ihre Startzahl =" + zahl);
			
	// Ungerade Zahlen berechnen
			
			for(int i = zahl; i >= 1; i -= 1){
					if (i %2 !=0) {
						System.out.print(i + " | ");
					}	
			}		
	}

}
