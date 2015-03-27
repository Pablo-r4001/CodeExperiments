import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer
{
	private JTextArea display; //the display
	private JTextArea answer; // answer is invisble until button is pressed
	private ArrayList<QuizCard> cardList; //all of the card objects go here
	private QuizCard currentCard; // it takes the form of the card that one's currently working with.
	private int currentCardIndex; // it is a number of the card that we're using
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer; //if true declares the answer of the card

	public static void main(String[] args)
	{
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}

	public void go()
	{

		frame = new JFrame("Quiz Card Player");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);

		display = new JTextArea(10,20);
		display.setFont(bigFont);

		display.setLineWrap(true);
		display.setEditable(false);

		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640,500);
		frame.setVisible(true);
	}

	public class NextCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(isShowAnswer)
			{
				//show the answer because they've seen the question
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}
			else
			{
				//show the next question
				if(currentCardIndex < cardList.size())
				{
					showNextCard();
				}
				else
				{
					// there are no more cards
					display.setText("That was the last card!");
				}
			}
		}
	}

	public class OpenMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}

	private void loadFile(File file)
	{
		cardList = new ArrayList<QuizCard>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				makeCard(line);
			}
			reader.close();

		}
		catch(Exception ex)
		{
			System.out.println("couldn't read the card file");
			ex.printStackTrace();
		}
		//now we show the first card
		showNextCard();

	}

	private void makeCard(String lineToParse)
	{
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}

	private void showNextCard()
	{
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
}