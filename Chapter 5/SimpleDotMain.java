class SimpleDotMain
{
	public static void main(String[] args)
	{
		SimpleDotCom theDotCom = new SimpleDotCom();
		int numOfGuesses = 0;
		int [] locations = new int[3];
		boolean stillOn = true;
		GameHelper helper = new GameHelper();
		
		locations[0] = (int)(Math.random()*5);
		locations[1] = locations[0]+1;
		locations[2] = locations[0]+2;
		theDotCom.setLocationCells(locations);
		
		while(stillOn ==true)
		{
			String guess = helper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("kill"))
			{
			stillOn = false;
			System.out.println("You took " + numOfGuesses + " guesses.");
			}
		}
	}
}