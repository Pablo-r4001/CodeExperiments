import java.io.*;

public class GameSaverTest
{
	public static void main(String[] args)
	{
		//first we make some characters these parameters are recieved by the GameCharacter constructor in the GameCharacter Class
		GameCharacter one = new GameCharacter(50,"Elf", new String[]{"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(200,"Troll", new String[]{"bare hands", "big ass axe"});
		GameCharacter three = new GameCharacter(120,"Magician", new String[]{"spells", "invisibility"});

		//imaginary code that does things with the characters that changes their state values
		//remember java.io always produces an IOException
		try
		{
			//This is a connection stream os which is writting to a new "Game.ser" file via a chain stream the 
			//new file output is a parameter
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			//this writes the GameCharacter objects into the os ObjectOutputStram
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		//We blank out our objets so the next phase cna be done
		one = null;
		two = null;
		three = null;

		//again IO always has to catch an IOException
		try
		{
			/*
			We restore using the same steps as above to save
			we create a ccreate a new connection stream which takes as parameter a connection stream
			*/
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
			//we create new objects fore the restored 
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();
			//we test the new restored values
			System.out.println("One's type: " + oneRestore.getType());
			System.out.println("Two's type: " + twoRestore.getType());
			System.out.println("Three's type: " + threeRestore.getType());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}