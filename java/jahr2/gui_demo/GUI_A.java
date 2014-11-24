package gui_demo;

import java.awt.BorderLayout;

public class GUI_A extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_Durchmesser;
	private JTextField textField_Ausgabe;
	private int input_durchmesser;
	private int input_breite;
	private int input_winkel;
	private double output;
	private JTextField textField_Breite;
	private JTextField textField_Winkel;

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
					GUI_A frame = new GUI_A();
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
	public GUI_A()
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
		
		textField_Durchmesser = new JTextField();
		textField_Durchmesser.addKeyListener(new KeyAdapter() {
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
		textField_Durchmesser.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Durchmesser.setBounds(10, 25, 135, 37);
		contentPane.add(textField_Durchmesser);
		textField_Durchmesser.setColumns(10);
		
		textField_Ausgabe = new JTextField();
		textField_Ausgabe.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Ausgabe.setEditable(false);
		textField_Ausgabe.setColumns(10);
		textField_Ausgabe.setBounds(10, 84, 424, 37);
		contentPane.add(textField_Ausgabe);
		
		JButton btnDezimalInDual = new JButton("L\u00E4nge berechnen");
		btnDezimalInDual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
			  {
					input_durchmesser = Integer.parseInt(textField_Durchmesser.getText());
					input_breite = Integer.parseInt(textField_Breite.getText());
					input_winkel = Integer.parseInt(textField_Winkel.getText());
					
					
					
					output = (Math.PI * ( input_durchmesser - input_breite ) * input_winkel ) / 360;					
					textField_Ausgabe.setText(String.valueOf(output));
			  } catch (Exception e2) {
				}
				textField_Durchmesser.requestFocus();
				textField_Durchmesser.selectAll();
			
			}
		});
		btnDezimalInDual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDezimalInDual.setBounds(63, 132, 295, 49);
		contentPane.add(btnDezimalInDual);
		
		textField_Breite = new JTextField();
		textField_Breite.addKeyListener(new KeyAdapter() {
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
		textField_Breite.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Breite.setColumns(10);
		textField_Breite.setBounds(154, 25, 135, 37);
		contentPane.add(textField_Breite);
		
		textField_Winkel = new JTextField();
		textField_Winkel.addKeyListener(new KeyAdapter() {
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
		textField_Winkel.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Winkel.setColumns(10);
		textField_Winkel.setBounds(299, 25, 135, 37);
		contentPane.add(textField_Winkel);
		
		JLabel lblDurchmesser = new JLabel("Durchmesser");
		lblDurchmesser.setBounds(10, 11, 73, 14);
		contentPane.add(lblDurchmesser);
		
		JLabel lblBreite = new JLabel("Breite");
		lblBreite.setBounds(154, 11, 73, 14);
		contentPane.add(lblBreite);
		
		JLabel lblWinkel = new JLabel("Winkel");
		lblWinkel.setBounds(299, 11, 73, 14);
		contentPane.add(lblWinkel);
		
		JLabel lblLnge = new JLabel("L\u00E4nge");
		lblLnge.setBounds(10, 69, 73, 14);
		contentPane.add(lblLnge);
	}
}
