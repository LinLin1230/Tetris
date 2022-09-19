package tetris;

public class Data 
{
	static byte[][] basicMatrix = new byte[23][10];
	static byte[][] displayMatrix = new byte[23][10];
	static Block block;
	static Block blockNext;
	static int score;
	static int player=0;
	static int delay =10;
	static boolean pause=false;
	public static void initial()
	{
		for(int i=0;i<22;i++)
			for(int j=0;j<10;j++)
			{
				basicMatrix[i][j] = 0;
				
			}
		for(int j=0;j<10;j++)
		{
			basicMatrix[22][j] = 1;
			
		}
		newBlock();
		newBlock();
		score = 0;
	}
	public static void displayMatrixRefresh()
	{
		for(int i=0;i<22;i++)
			for(int j=0;j<10;j++)
			{
				displayMatrix[i][j] = basicMatrix[i][j];
			}
		for(int i=0;i<4;i++)
		{
			byte x = (byte) (block.position_x+block.mode[block.mode_num][i][0]);
			byte y = (byte) (block.position_y+block.mode[block.mode_num][i][1]);
			displayMatrix[x][y]=(byte) (basicMatrix[x][y]+1);
		}
		
	}
	public static void newBlock()
	{
		block = blockNext;
		byte num = (byte) (Math.random()*7);
		switch(num)
		{
		case 0:
			blockNext = new Block_I();
			break;
		case 1:
			blockNext = new Block_J();
			break;
		case 2:
			blockNext = new Block_L();
			break;
		case 3:
			blockNext = new Block_O();
			break;
		case 4:
			blockNext = new Block_S();
			break;
		case 5:
			blockNext = new Block_T();
			break;
		case 6:
			blockNext = new Block_Z();
			break;
		}
	}
	public static void reset() //reset
	{
		for(int i=0;i<22;i++)
			for(int j=0;j<10;j++)
			{
				basicMatrix[i][j] = 0;
			}
		for(int j=0;j<10;j++)
		{
			basicMatrix[22][j] = 1;
		}
		
	}

}
