import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardBuilder
{
	//private reference variables to the areas containing questions answers and the frame
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;

	//The main creates a QuizCardBuilder object and calls the go method in that object
	public static void main(String[] args)
	{
		QuizCardBuilder quizBuilder = new QuizCardBuilder();
		quizBuilder.go();
	}

	//Making the UI
	public void go()
	{
		//Name the frame, invoque a panel, make a font, set new textarea for question
		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		question = new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);

		//Question scrollbar rules also set the question to qScroller
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		//create answer textarewa with parameters
		answer = new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);

		//answer rules for the scrollbar also set the answer to aScroller
		JScrollPane aScroller = new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		//create new Button for next card
		JButton nextButton = new JButton("Next Card");

		//New arraylist for cardlist
		cardList = new ArrayList<QuizCard>();

		//Labels for the textboxes	
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");

		//adding the parts to the pannel
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);

		// addActionListener to 
		nextButton.addActionListener(new NextCardListener());
		
		// add a menu bar, add a menu to the menu bar, and add the save and new items with their respective listeners
		//the listeners call the inner classes
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);

		//this gets the contentpane, sets the size and makes visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);


	}

	// this listens for the next button
	public class NextCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			//This gets a new card incluiding the question and answer
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	public class SaveMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			//This is used to save a card to the cardlist also calls the savefile method
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);

			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}

	public class NewMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			//this clears a card to add a new one calls the clearcardmethod
			cardList.clear();
			clearCard();
		}
	}

	private void clearCard()
	{
		//The clearCard Method is in order to set the text of a certain card to ""
 		question.setText("");
		answer.setText("");
		question.requestFocus();
	}

	//saveFile Method that tries to get  bufferedwritter that takes a filewritter for a file
	private void saveFile(File file)
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			for(QuizCard card : cardList)
			{
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}
			writer.close();
		}
		catch(IOException ex)
		{
			System.out.println("Couldn't write the cardList out");
			ex.printStackTrace();
		}
	}
}
