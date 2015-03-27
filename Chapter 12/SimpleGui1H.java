import javax.swing.*;
import java.awt.*;

public class SimpleGui1H
{
	//JButton button;	
	public static void main (String[] args)
	{
		SimpleGui1H gui = new SimpleGui1H();
		
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		MyRandomCircle Pannel = new MyRandomCircle();
		frame.getContentPane().add(BorderLayout.CENTER, Pannel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	//public void actionPerformed(ActionEvent event)
	//{
		//button.setText("I've been clicked");
	//}
}
