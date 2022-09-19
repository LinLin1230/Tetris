package tetris;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
public class TetrisPanel extends JPanel
{
	public TetrisPanel()
	{
		this.setLayout(null);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i=0;i<22;i++)
			for(int j=0;j<10;j++)
				if(Data.displayMatrix[i][j]==1)
					g.fillRect(20*j+1, 20*i+1, 18, 18);
	}
}
