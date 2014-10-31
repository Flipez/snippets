package true_airspeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TAS_Programm
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//Begrüßung:
		System.out.println("Programm zur Berechnung der TAS eines Luftfahrzeuges.");
		//Deklarierung bzw. Initialisierung der Verarbeitungsvariablen
		double tas, fHoehe, ias = 0;
		final double konstante = 0.02;
		char abfrage;
		//Verarbeitung der Tastatureingabe:
		InputStreamReader iReader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(iReader);
		System.out.println("Wählen Sie:\n\tS = Segelflug | M = Motorflug: ");
		abfrage = bReader.readLine().charAt(0);
		switch (abfrage)
		{
		case 'M':
			//Benutzerführung + Eingabeverarbeitung
			System.out.print("Geben Sie die Flughöhe [ft] ein: ");
			fHoehe = Integer.parseInt(bReader.readLine());
			System.out.print("Geben Sie die IAS [kn] ein:");
			ias = Integer.parseInt(bReader.readLine());
			//Verarbeitung der Variablen: Berechnung der TAS
			tas = ias + (fHoehe * konstante * ias) / 1000;
			System.out.println("Die TAS beträgt: " + tas + " kn");
			break;
		case 'S':
		//Benutzerführung + Eingabeverarbeitung
			System.out.print("Geben Sie die Flughöhe [m] ein: ");
			fHoehe = (Integer.parseInt(bReader.readLine())) * 3.3;
			System.out.print("Geben Sie die IAS [km/h] ein:");
			ias = (Integer.parseInt(bReader.readLine())) * 0.539956803;
			//Verarbeitung der Variablen: Berechnung der TAS
			tas = (ias + (fHoehe * konstante * ias) / 1000) * 1.852;
			System.out.println("Die TAS beträgt: " + tas + " km/h");
			break;
		default:
			System.out.println("Auswahl nicht hinterlegt. Programm wird beendet");
			System.exit(0);
			break;
		}
		
		
	}

}
