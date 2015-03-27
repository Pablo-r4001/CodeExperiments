import javax.swing.*;
import java.awt.*;

public class ButtonsErrWhere
{

	public static void main(String[] args)
	{
		ButtonsErrWhere gui = new ButtonsErrWhere();
		gui.go();
	}

	public void go()
	{
		JFrame frame = new JFrame();

		JButton north = new JButton("North Side");
		JButton south = new JButton("Dirty South");
		JButton east = new JButton("East Side");
		JButton west = new JButton("West Side");
		JButton center = new JButton("ChiTown Drill");

		frame.getContentPane().add(BorderLayout.NORTH, north);
		frame.getContentPane().add(BorderLayout.SOUTH, south);
		frame.getContentPane().add(BorderLayout.EAST, east);
		frame.getContentPane().add(BorderLayout.WEST, west);
		frame.getContentPane().add(BorderLayout.CENTER, center);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(600,600);
		frame.setVisible(true);
	}
}