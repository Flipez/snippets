package schaltjahr;

import javax.swing.JOptionPane;

public class schaltjahr
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int jahr = 0, spalte = 0;
		String InputStrom, ausgabe ="";
		InputStrom = JOptionPane.showInputDialog("Geben Sie das Startjahr ein!");
		jahr = Integer.parseInt(InputStrom);
		if (jahr <= 0) {
			JOptionPane.showMessageDialog(null, "Kein gültiges Jahr! \nDas Programm wird beendet!!");
			System.exit(0);
		} else {
			do
			{
				if (jahr % 4 == 0 || (jahr % 400 == 0 && jahr % 100 != 0)) {
					ausgabe += jahr + " ";
					jahr -=  1;
					
					spalte++;
					if (spalte == 16) {
						ausgabe = ausgabe + "\n";
						spalte = 0;
					}
				} else {
					jahr -= 1;
				}
			} while (jahr > 0);
			JOptionPane.showMessageDialog(null, ausgabe);
			System.exit(0);
		}
	}

}
