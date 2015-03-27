import javax.swing.*;
import java.awt.*;

public class Panel4
{

	public static void main(String[] args)
	{
		Panel4 gui = new Panel4();
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

		panel.setLayout(new BoxLayout(panel, BoxLayout.YN_AXIS));

		panel.add(button);
		panel.add(button1);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
