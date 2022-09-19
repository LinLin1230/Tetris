package tetris;

public class Player extends Thread
{
	static Block block;
	static Block blockNext;
	static byte [][] tempMatrix = new byte[23][10];
	static byte [][] storeMatrix = new byte[23][10];
	static byte [][] scoreMatrix = 
		{
		{1,1,1,1,1,1,1,1,1,1},
		{2,2,2,2,2,2,2,2,2,2},
		{3,3,3,3,3,3,3,3,3,3},
		{4,4,4,4,4,4,4,4,4,4},
		{5,5,5,5,5,5,5,5,5,5},
		{6,6,6,6,6,6,6,6,6,6},
		{7,7,7,7,7,7,7,7,7,7},
		{8,8,8,8,8,8,8,8,8,8},
		{9,9,9,9,9,9,9,9,9,9},
		{10,10,10,10,10,10,10,10,10,10},
		{11,11,11,11,11,11,11,11,11,11},
		{12,12,12,12,12,12,12,12,12,12},
		{13,13,13,13,13,13,13,13,13,13},
		{14,14,14,14,14,14,14,14,14,14},
		{15,15,15,15,15,15,15,15,15,15},
		{16,16,16,16,16,16,16,16,16,16},
		{17,17,17,17,17,17,17,17,17,17},
		{18,18,18,18,18,18,18,18,18,18},
		{19,19,19,19,19,19,19,19,19,19},
		{20,20,20,20,20,20,20,20,20,20},
		{21,21,21,21,21,21,21,21,21,21},
		{22,22,22,22,22,22,22,22,22,22}
	};
	static int score = 0;
	static int changeTimes;
	static int rightTimes;
	public static void solve()
	{
		changeTimes=0;
		rightTimes=0;
		score=0;
		for(int i1=0;i1<4;i1++)
		{
			for(int i2=0;i2<10;i2++)
			{
				block = (Block) Data.block.clone();
				block.position_x = 3; 
				for(int x=0;x<23;x++)
					for(int y=0;y<10;y++)
					{
						tempMatrix[x][y] = Data.basicMatrix[x][y];
					}
				for(int temp=0;temp<i1;temp++)
					change(block);
				for(int temp=0;temp<5;temp++)
					left(block);
				for(int temp=0;temp<i2;temp++)
					right(block);
				while(down(block));
				for(int i=0;i<4;i++)
				{
					byte x = (byte) (block.position_x+block.mode[block.mode_num][i][0]);
					byte y = (byte) (block.position_y+block.mode[block.mode_num][i][1]);
					tempMatrix[x][y]=(byte) (tempMatrix[x][y]+1);
				}
				for(int x=0;x<23;x++)
					for(int y=0;y<10;y++)
					{
						storeMatrix[x][y] = tempMatrix[x][y];
					}
				
				for(int i3=0;i3<4;i3++)
				{
					for(int i4=0;i4<10;i4++)
					{
						blockNext = (Block) Data.blockNext.clone();
						blockNext.position_x = 3;
						for(int x=0;x<23;x++)
							for(int y=0;y<10;y++)
							{
								tempMatrix[x][y] = storeMatrix[x][y];
							}
						for(int temp=0;temp<i3;temp++)
							change(blockNext);
						for(int temp=0;temp<5;temp++)
							left(blockNext);
						for(int temp=0;temp<i4;temp++)
							right(blockNext);
						while(down(blockNext));
						for(int i=0;i<4;i++)
						{
							byte x = (byte) (blockNext.position_x+blockNext.mode[blockNext.mode_num][i][0]);
							byte y = (byte) (blockNext.position_y+blockNext.mode[blockNext.mode_num][i][1]);
							tempMatrix[x][y]=(byte) (tempMatrix[x][y]+1);
						}
						
						if(rank(tempMatrix)>score)
						{
							score = rank(tempMatrix);
							changeTimes = i1;
							rightTimes = i2;
						}
					}
				}
				
				/*
				if(rank(tempMatrix)>score)
				{
					score = rank(tempMatrix);
					changeTimes = i1;
					rightTimes = i2;
				}
				*/
			}
			
		}
		act();
			
	}
	public static void act()
	{
		for(int i=0;i<changeTimes;i++)
			Data.block.change();
		for(int i=0;i<5;i++)
			Data.block.left();
		for(int i=0;i<rightTimes;i++)
			Data.block.right();
	}
	public static int rank(byte[][]matrix)
	{
		/*
		int score = 0;
		for(int i=0;i<22;i++)
			for(int j=0;j<10;j++)
				if(matrix[i][j]==1)
					score += scoreMatrix[i][j];
				else
				{
					if(i>1&&matrix[i-1][j]==1)
						score -= 5;
				}
		return score;
		*/
		int score = 100;
		for(int i=0;i<22;i++){
			for(int j=0;j<10;j++){
				if(j >= 1 && matrix[i][j] != matrix[i][j - 1])
					score--;
				if(i>1 && matrix[i-1][j]==1 && matrix[i][j]==0)
					score -= 5;
			}
		}
		for (int i = 1; i < 22; i++){
			if(matrix[i][0] == 1 && matrix[i][2] == 1 && matrix[i][3] == 1 && matrix[i][4] == 1 && matrix[i][5] == 1 && matrix[i][6] == 1 && matrix[i][7] == 1 && matrix[i][8] == 1 && matrix[i][9] == 1)
				score += 3;
		}
		//System.out.println("score: " + score);
		return score;
	}
	public static void left(Block block)
	{
		block.position_y--;
		if(!check(block))
			block.position_y++;
	}
	public static void right(Block block)
	{
		block.position_y++;
		if(!check(block))
			block.position_y--;
	}
	public static boolean down(Block block)
	{
		boolean boo = true;
		for(int i=0;i<4;i++)
		{
			byte x = (byte) (block.position_x+block.mode[block.mode_num][i][0]+1);
			byte y = (byte) (block.position_y+block.mode[block.mode_num][i][1]);
			if(tempMatrix[x][y]==1)
			{
				boo=false;
				break;
			}
		}
		if(!boo)
		{
			return false;
		}
		else
		{
			block.position_x++;
			return true;
		}
		
	}
	public static void change(Block block)
	{
		block.mode_num = (byte) ((block.mode_num+1)%4);
		if(!check(block))
			block.mode_num = (byte) ((block.mode_num+3)%4);
	}
	public static boolean check(Block block)
	{
		boolean b=true;
		for(int i=0;i<4;i++)
		{
			byte x = (byte) (block.position_x+block.mode[block.mode_num][i][0]);
			byte y = (byte) (block.position_y+block.mode[block.mode_num][i][1]);
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
			if(tempMatrix[x][y]==1)
			{
				b=false;
				break;
			}
				
		}
		return b;
	}
	public void run()
	{
		try {
			this.sleep(Data.delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Data.player==1)
			solve();
	}


}
