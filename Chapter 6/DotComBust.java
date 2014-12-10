import java.util.*;

public class DotComBust
{
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame()
	{
	
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com and Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		for(DotCom dotComToSet: dotComsList)
		{
				ArrayList<String> newLocation = helper.placeDotCom(3);
				
				dotComToSet.setLocationCells(newLocation);
		}
	}

	private void startPlaying()
	{
	
		while(!dotComsList.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess)
	{
	
		numOfGuesses++;
		
		String result = "miss";
		
		for (int x = 0; x < dotComsList.size(); x++)
		{
		
			result = dotComsList.get(x).checkYourself(userGuess);
			
			if (result.equals("hit"))
			{
				break;
			}
			if (result.equals("kill"))
			{
			
				dotComsList.remove(x);
				break;
			
			}
		}
		
		System.out.println(result);
	}
	
	private void finishGame()
	{
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		
		if (numOfGuesses <= 18)
		{
		
			System.out.println( "It only took you" + numOfGuesses + "guesses!");
			System.out.println("You got out before all your options sank");
		
		}
		
		else
		
		{
		
		System.out.println( "Took you long enough. IT took you" + numOfGuesses + "guesses! Holy SHIT! are you stupid or something?");
		System.out.println("You're financially ruined, dumbass.");
		
		}
	}
	
	public static void main (String[] args)
	{
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}
