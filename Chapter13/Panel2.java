import javax.swing.*;
import java.awt.*;

public class Panel2
{

	public static void main(String[] args)
	{
		Panel2 gui = new Panel2();
		gui.go();
	}

	public void go()
	{

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Shock Me");
		panel.setBackground(Color.darkGray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(button);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
