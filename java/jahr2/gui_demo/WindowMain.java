package gui_demo;

import java.awt.Window.Type;


public class WindowMain
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WindowForm myWindow = new WindowForm();
		myWindow.setDefaultCloseOperation(WindowForm.EXIT_ON_CLOSE);
		//myWindow.setBounds(200, 200, 225, 135);
		//myWindow.setType(Type.UTILITY);
		//myWindow.setTitle("Changing");
		//myWindow.setResizable(false);
		
		myWindow.setVisible(true);
	}

}
