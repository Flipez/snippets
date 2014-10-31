package Leistungskontrollen;
import javax.swing.JOptionPane;


public class Leistungskontrolle_1
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Deklariere Variablen
		int month = 0;
		String input = null;
		boolean restart = true;
		
		// Deklariere month dataset für einfache Ausgabe der Monatsnamen
		String month_data[] = { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember" };
		
		// Ausgabe der Begrüßung
		JOptionPane.showMessageDialog(null, "Willkommen zur Umrechnung der Montaszahl in den Monatsnamen! \nSie können das Programm mit dem betätigen von Abbrechen beenden.");
		
		//Starte loop in dem das Programm bis zum beenden läuft
		do
		{
			//Starte Benutzerführung
			
			input = JOptionPane.showInputDialog("Bitte geben Sie den Monat als Zahl ein. [Format 1 - 12]");
			if (input == null) //Wenn der Benutzer auf abbrechen klickt gibt JOptionPane null zurück -> Programm beenden
			{
				restart = false;
				JOptionPane.showMessageDialog(null, "Das Programm wurde durch den Benutzer beendet.");
			} else {
				try { 
					// Versuche Eingabe zu parsen, bei Eingabe von Buchstaben o.Ä -> NubmerFormatException
					month = Integer.parseInt(input);
					// Wenn erfolgreich -> Gebe Monatsnamen aus
					if (month > 0 && month <= 12)
					{
						JOptionPane.showMessageDialog(null, month_data[month - 1]);
					}
				}	 catch(NumberFormatException e) { 
					// Offensichtlich kein Integer Wert eingegeben, fange Fehler und starte Programm neu
				}
			}
		} while (restart);{}
	}

}
