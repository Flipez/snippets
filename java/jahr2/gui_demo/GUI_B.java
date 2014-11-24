package gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI_B extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_Eingabe;
	private JTextField textField_Dualzahl;
	private int dezimal;
	private String  dual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI_B frame = new GUI_B();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_B()
	{
		
		
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Dezimal in dual");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_Eingabe = new JTextField();
		textField_Eingabe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent keyT) {
				if (!Character.isDigit(keyT.getKeyChar()) 
						&& keyT.getKeyChar() != KeyEvent.VK_ENTER
						&& keyT.getKeyChar() != KeyEvent.VK_DELETE
						&& keyT.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					JOptionPane.showMessageDialog(null, "Es dürfen keine Buchstaben eingegeben werden!");
					keyT.consume();
				}
			}
		});
		textField_Eingabe.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Eingabe.setBounds(10, 11, 424, 37);
		contentPane.add(textField_Eingabe);
		textField_Eingabe.setColumns(10);
		
		textField_Dualzahl = new JTextField();
		textField_Dualzahl.setEditable(false);
		textField_Dualzahl.setColumns(10);
		textField_Dualzahl.setBounds(10, 59, 424, 37);
		contentPane.add(textField_Dualzahl);
		
		JButton btnDezimalInDual = new JButton("Dezimal in Dual");
		btnDezimalInDual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
			  {
					dezimal = Integer.parseInt(textField_Eingabe.getText());
					dual = Integer.toBinaryString(dezimal);
					textField_Dualzahl.setText(dual);
			  } catch (Exception e2) {
				}
				textField_Eingabe.requestFocus();
				textField_Eingabe.selectAll();
			
			}
		});
		btnDezimalInDual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDezimalInDual.setBounds(63, 107, 295, 49);
		contentPane.add(btnDezimalInDual);
	}
}
