import javax.swing.*;
import java.awt.*;

public class Button3
{

	public static void main(String[] args)
	{
		Button3 gui = new Button3();
		gui.go();
	}

	public void go()
	{
		JFrame frame = new JFrame();
		JButton button = new JButton("I like it when you click me right thurr");
		Font bigFont = new Font("serif", Font.BOLD, 23);
		button.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.NORTH, button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,200);
		frame.setVisible(true);
	}
}