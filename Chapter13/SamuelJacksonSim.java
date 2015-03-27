import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SamuelJacksonSim 
{
	int x = 0;
	JButton what = new JButton("What?");
	JLabel samuel = new JLabel("What country are you from?");

	public static void main(String[] Args)
	{
		SamuelJacksonSim samJac = new SamuelJacksonSim();
		samJac.go();
	}

	public void go()
	{
		JFrame frame = new JFrame("Samuel Jackson Simulator");
		JPanel panel = new JPanel();

		what.addActionListener(new ClickyClick());

		panel.add(what);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, samuel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,200);
		frame.setVisible(true);
	}	

	public class ClickyClick implements ActionListener
	{

		public void actionPerformed(ActionEvent event)
		{
			
			x++;

			if (x == 1)
			{
				samuel.setText("'What' ain't no country I've ever heard of. They speak English in What?");
				what.setText("What?");
			}
			if (x == 2)
			{
				samuel.setText("English, motherfucker, do you speak it?");
				what.setText("Yes! Yes!");
			}
			if (x == 3)
			{
				samuel.setText(" Then you know what I'm sayin'!");
				what.setText("Yes!");
			}
			if (x == 4)
			{
				samuel.setText(" Describe what Marsellus Wallace looks like!");
				what.setText("What?");
			}
			if (x == 5)
			{
				samuel.setText("Say 'what' again. Say 'what' again, I dare you, I double dare you motherfucker, say what one more Goddamn time!");
				what.setText("Say What again.");
			}
			if (x > 5)
			{
				x = 0;
				samuel.setText("What country are you from?");
				what.setText("What?");
			}
		}
	}
}