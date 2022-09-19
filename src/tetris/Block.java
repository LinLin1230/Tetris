package tetris;

public class Block implements Cloneable
{
	byte position_x;
	byte position_y;
	byte mode_num;
	byte [][][] mode;
	public Block(byte position_x,byte position_y,byte [][][] mode)
	{
		this.position_x = position_x;
		this.position_y = position_y;
		mode_num = 0;
		this.mode = mode;
	}
	public void left()
	{
		position_y--;
		if(!check())
			position_y++;
		MainFrame.refresh();
	}
	public void right()
	{
		position_y++;
		if(!check())
			position_y--;
		MainFrame.refresh();
	}
	public void down()
	{
		byte[][] tempMatrix = new byte[23][10];
		byte[][] basicMatrix = Data.basicMatrix;
		for(int i=0;i<22;i++)
			for(int j=0;j<10;j++)
				tempMatrix[i][j] = basicMatrix[i][j];
		
		//是否到底
		boolean boo = true;
		for(int i=0;i<4;i++)
		{
			byte x = (byte) (position_x+mode[mode_num][i][0]+1);
			byte y = (byte) (position_y+mode[mode_num][i][1]);
			if(basicMatrix[x][y]==1)
			{
				boo=false;
				break;
			}
		}
		if(!boo)
		{
			for(int i=0;i<4;i++)
			{
				byte x = (byte) (position_x+mode[mode_num][i][0]);
				byte y = (byte) (position_y+mode[mode_num][i][1]);
				basicMatrix[x][y]=(byte) (basicMatrix[x][y]+1);
			}
			
			for(int i=0;i<22;i++)
			{
				boolean boo1=true;
				for(int j=0;j<10;j++)
				{
					if(basicMatrix[i][j]==0)
						boo1=false;
				}
				if(boo1)
				{
					for(int k=i;k>1;k--)
					{
						for(int l=0;l<10;l++)
						{
							basicMatrix[k][l] = basicMatrix[k-1][l];
						}
					}
					Data.score++;
				}
			}
			Data.newBlock();
			new Player().start();
			MainFrame.refresh();
		}
		else
		{
			position_x++;
			MainFrame.refresh();
		}
		//是否到顶
		for(int i=0;i<2;i++)
		{
			boo=true;
			for(int j=0;j<10;j++)
			{
				if(basicMatrix[i][j]==1)
					boo=false;
			}
			if(!boo)
			{
				System.out.println(Data.score);
				Data.score = 0;
				Data.reset();
				Data.newBlock();
				MainFrame.refresh();
			}
		}
	}
	public void change()
	{
		mode_num = (byte) ((mode_num+1)%4);
		if(!check())
			mode_num = (byte) ((mode_num+3)%4);
		MainFrame.refresh();
	}
	public boolean check()
	{
		boolean b=true;
		for(int i=0;i<4;i++)
		{
			byte x = (byte) (position_x+mode[mode_num][i][0]);
			byte y = (byte) (position_y+mode[mode_num][i][1]);
			if(x<0 | x>22)
			{
				b=false;
				break;
			}		
			if(y<0 | y>9)
			{
				b=false;
				break;
			}
			if(Data.basicMatrix[x][y]==1)
			{
				b=false;
				break;
			}
				
		}
		return b;
	}
	@Override
    public Object clone() 
	{
        try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
    }
}
