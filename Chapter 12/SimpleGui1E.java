import javax.swing.*;
import java.awt.*;

public class SimpleGui1E
{
	//JButton button;	
	public static void main (String[] args)
	{
		SimpleGui1E gui = new SimpleGui1E();
		
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		//button = new JButton("click me");
		
		
		
		//button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NewPannel Pannel = new NewPannel();
		frame.getContentPane().add(BorderLayout.CENTER, Pannel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	//public void actionPerformed(ActionEvent event)
	//{
		//button.setText("I've been clicked");
	//}
}
