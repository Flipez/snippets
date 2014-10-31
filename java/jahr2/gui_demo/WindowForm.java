package gui_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WindowForm extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text_Dezimalzahl, text_Dualzahl;
	private JButton button_Umwandeln;
	private int dezimal;
	private String dual;
	private void init()
	{
		text_Dezimalzahl = new JTextField();
		text_Dualzahl = new JTextField();
		button_Umwandeln = new JButton("Dezimal in Dual");

		text_Dezimalzahl.setBounds(10, 10, 200, 25);
		text_Dezimalzahl.setActionCommand("eingabe");
		text_Dualzahl.setBounds(10, 40, 200, 25);
		text_Dualzahl.setEnabled(false);
		button_Umwandeln.setBounds(10, 70, 200, 25);
		button_Umwandeln.setActionCommand("start");

		this.getContentPane().add(text_Dezimalzahl);
		this.getContentPane().add(text_Dualzahl);
		this.getContentPane().add(button_Umwandeln);

		button_Umwandeln.addActionListener(new ActionLauscher());
		text_Dezimalzahl.addActionListener(new ActionLauscher());
		text_Dezimalzahl.addKeyListener(new Schutz());
	}
	public WindowForm()
	{
		// TODO Auto-generated constructor stub
		// Festlegung der Fenstergröße und Fensterposition
		this.setBounds(200, 200, 225, 135);
		// Festlegung des Fensteraussehens
		this.setType(Type.UTILITY);
		this.setTitle("Changing");
		this.setResizable(false);
		// Festlegung des Fensterlayouts
		this.getContentPane().setLayout(null);
		// Aufruf der Methode für das Aufrufend er grafischen Elemente des Fensters
		init();
	}
	private class ActionLauscher implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if (e.getActionCommand().equalsIgnoreCase("start") || e.getActionCommand().equalsIgnoreCase("eingabe"))
			{
				try
			  {
					dezimal = Integer.parseInt(text_Dezimalzahl.getText());
					dual = Integer.toBinaryString(dezimal);
					text_Dualzahl.setText(dual);
			  } catch (Exception e2) {
				}
				text_Dezimalzahl.requestFocus();
				text_Dezimalzahl.selectAll();
			}
		}
	}
	private class Schutz implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent keyP)
		{
			// TODO Auto-generated method stub
		}
		@Override
		public void keyReleased(KeyEvent keyR)
		{
			// TODO Auto-generated method stub
		}
		@Override
		public void keyTyped(KeyEvent keyT)
		{
			// TODO Auto-generated method stub
			if (!Character.isDigit(keyT.getKeyChar()) 
					&& keyT.getKeyChar() != KeyEvent.VK_ENTER
					&& keyT.getKeyChar() != KeyEvent.VK_DELETE
					&& keyT.getKeyChar() != KeyEvent.VK_BACK_SPACE)
			{
				JOptionPane.showMessageDialog(null, "Es dürfen keine Buchstaben eingegeben werden!");
				keyT.consume();
			}
		}
	}
}
