import javax.swing.*;
import java.awt.*;

public class Panel3
{

	public static void main(String[] args)
	{
		Panel3 gui = new Panel3();
		gui.go();
	}

	public void go()
	{

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Shock Me");
		JButton button1 = new JButton("BLISS");
		panel.setBackground(Color.darkGray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(button);
		panel.add(button1);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
