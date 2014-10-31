package notenermittlung;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Notenverteilung
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int noten[]; //Array für Einzelnoten
		int note_1 = 0, note_2 = 0, note_3 =0, note_4 = 0, note_5 = 0, note_6 = 0; //Zählvariablen für Einzelnoten
		boolean neustart = false;
		/*
		 * notenEingabe nimmt die Usereingabe auf
		 * korrekturNoten nimmt alle richtigen Noten auf
		 */
		String notenEingabe, korrekturNoten = "", ausgabeVerteilung = "";
		JOptionPane.showMessageDialog(null, "Ermittlung von Notenverteilungen");
		//Nutzereingabe
		
		do
		{
			notenEingabe = JOptionPane.showInputDialog("Gib alle Noten ein!");
			if (notenEingabe == null)
			{
				JOptionPane.showMessageDialog(null, "Keine Noteneingabe! \nDas Programm wird beendet!!");
				System.exit(0);
			}
			else if (notenEingabe.length() == 0 )
			{
				JOptionPane.showMessageDialog(null, "Keine Noteneingabe! \nDas Programm wird beendet!!");
				System.exit(0);
			}
			for (int i = 0; i < notenEingabe.length(); i++)
			{
				if (Character.isDigit(notenEingabe.charAt(i)) && Integer.parseInt(String.valueOf(notenEingabe.charAt(i))) > 0 && Integer.parseInt(String.valueOf(notenEingabe.charAt(i))) < 7)
				{
					korrekturNoten += notenEingabe.charAt(i);
				}
			}
			noten = new int[korrekturNoten.length()];
			for (int i = 0; i < noten.length; i++)
			{
				noten[i] = Integer.parseInt(String.valueOf(korrekturNoten.charAt(i)));
			}
			for (int i = 0; i < noten.length; i++)
			{
				switch (noten[i])
				{
				case 1:
					note_1++;
					break;
					
				case 2:
					note_2++;
					break;
					
				case 3:
					note_3++;
					break;
		
				case 4:
					note_4++;
					break;
		
				case 5:
					note_5++;
					break;
		
				case 6:
					note_6++;
					break;

				}
			
			}
			double durchschnitt;
			NumberFormat out = NumberFormat.getInstance(Locale.GERMANY);
			out.setMaximumFractionDigits(2);
			durchschnitt = (double) (1 * note_1 + 2 * note_2 + 3 * note_3 + 4 * note_4 + 5 * note_5 + 6 * note_6) / korrekturNoten.length() ;
		
			String ausgabe = "Notenanzahl:" +
					"\nNote 1: " + note_1 + 
					"\nNote 2: " + note_2 + 
					"\nNote 3: " + note_3 + 
					"\nNote 4: " + note_4 +
					"\nNote 5: " + note_5 + 
					"\nNote 6: " + note_6 +
					"\nDurchschnitt: " + out.format(durchschnitt) + "\nZeugnisnote = " + Math.round(durchschnitt);
			
			JOptionPane.showMessageDialog(null, ausgabe);
			if (JOptionPane.showInputDialog("Neueingabe?\nJa - j\nNein - ENTER").equals("j"))
			{
				note_1 = 0;
				note_2 = 0;
				note_3 = 0;
				note_4 = 0;
				note_5 = 0;
				note_6 = 0;
				durchschnitt = 0;
				korrekturNoten = "";
				notenEingabe = "";
			
				neustart = true;
			} else {
				JOptionPane.showMessageDialog(null, "Das Programm wird beendet");
				neustart = false;
			}
		} while (neustart);
		}
	}
