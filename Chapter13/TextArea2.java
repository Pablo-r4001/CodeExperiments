import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea2
{
	JTextArea text;
	JCheckBox check;
	private boolean isChecked;


	public static void main(String[] args)
	{
		TextArea2 gui = new TextArea2();
		gui.go();

	}

	public void go()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me, I dare you, I double Dare you!");
		check = new JCheckBox("Get Crazy");
		check.setSelected(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new Clicked());
		text = new JTextArea(10,20);
		text.setLineWrap(true);
		check.addItemListener(new CheckBoxing());



		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroller);

		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);

		frame.setSize(350,300);
		frame.setVisible(true);

	}

	public boolean setIsChecked(boolean i)
	{
		if(i = true){isChecked = true;} else{isChecked = false;}
		return isChecked;
	}

	public class Clicked implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(isChecked = true)
			{
				text.append("Not Crazy Enough \n");
			}
			else
			{
				text.append("Too CRAZY \n");
			}
		}
	}

	public class CheckBoxing implements ItemListener
	{
		public void itemStateChanged(ItemEvent ev)
		{
			gui.setIsChecked(check.isSelected());
		}
	}
}