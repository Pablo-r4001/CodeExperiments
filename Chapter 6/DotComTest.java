class testDotComBust
{
	
	testSetUpGame()
	{
		DotComBust setUpTest = new DotComBust;
		
		setUpTest.setUpGame();
		
		Assert.assertEquals(3,dotComsList.size());
	}
}