import javax.swing.*;
import java.awt.*;

public class TextField
{
	public static void main(String[] args)
	{
		TextField text = new TextField();	
		text.go();
	}

	public void go()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextField textField = new JTextField(20);
		textField.setText("MOTHERFUCKER");
		JLabel label = new JLabel("Label Society");

		panel.add(label);
		panel.add(textField);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		frame.setVisible(true);

	} 
}