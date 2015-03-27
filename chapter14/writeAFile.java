import java.io.*;
// import java io for FileWriter

class writeAFile
{
	public static void main(String[] args)
	{
		try
		{
			//invoke a new FileWriter object that target ("Foo.txt")
			// use FileWriter.write("string") to write to a file.
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("Hello Foo!");
			writer.close();
		}
		// with IO we always catch an IOException
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}