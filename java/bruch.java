package Weizen_calc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bruch
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// TODO Auto-generated method stub
		int a, b, g, r;

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
		
		//Ausgabe und entgegennahme Zahlen
	  
	  System.out.println("Berechnung von gemischten Zahlen.");
	  System.out.print("Geben Sie den Zähler ein: ");
	  a = Integer.parseInt(br.readLine()); 			//Zähler
	  System.out.print("Geben Sie den Nenner ein: ");
	  b = Integer.parseInt(br.readLine()); 			//Nenner
	  g = a / b;
    r = a % b;
	  
	  
    if (g == 1)

    {

          System.out.println("Der Bruch " + a + " / " + b + " ergibt in der Notationsart GANZE ZÄHLER/NENNER:\n\t" + g + " Ganzes und " + r + "/" + b + " !");

    } else

    {

          System.out.println("Der Bruch " + a + " / " + b + " ergibt in der Notationsart GANZE ZÄHLER/NENNER:\n\t" + g + " Ganze und " + r + "/" + b + " !");

    }

	  }

	}


