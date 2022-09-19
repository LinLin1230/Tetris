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
		g.drawString("score: " +Data.score, 50, 150);
		g.drawString("play: w/a/s/d", 50, 180);
		g.drawString("pause: p", 50, 200);
		g.drawString("auto/manual play: z", 50, 220);
		g.drawString("auto play speed:", 50, 240);
		g.drawString("normal: j", 60, 260);
		g.drawString("middle: k", 60, 280);
		g.drawString("fast: l", 60, 300);


	}

}
