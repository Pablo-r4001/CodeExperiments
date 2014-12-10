import javax.swing.*;
import java.awt.*;

public class SimpleGui1D
{
	//JButton button;	
	public static void main (String[] args)
	{
		SimpleGui1D gui = new SimpleGui1D();
		
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		//button = new JButton("click me");
		
		
		
		//button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NewImage rawr = new NewImage();
		frame.getContentPane().add(BorderLayout.CENTER, rawr);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	
	//public void actionPerformed(ActionEvent event)
	//{
		//button.setText("I've been clicked");
	//}
}
