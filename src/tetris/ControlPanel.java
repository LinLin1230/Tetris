package tetris;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class ControlPanel extends JPanel
{
	public ControlPanel()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		Block block = Data.blockNext;
		for(int i=0;i<4;i++)
		{
			byte x = (byte) (block.mode[block.mode_num][i][0]);
			byte y = (byte) (block.mode[block.mode_num][i][1]);
			g.fillRect(75+20*y+1, 60+20*x+1, 18, 18);
		}
		g.drawString(Data.score+"", 80, 150);
	}

}
