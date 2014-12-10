import java.awt.*;
import javax.swing.*;

class NewImage extends JPanel
{
	public void paintComponent(Graphics g)
	{
		Image image = new ImageIcon("1273421386883.jpg").getImage();
		g.drawImage(image,3,4,this);
		
	}
}
	