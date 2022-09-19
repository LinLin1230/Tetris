package tetris;

public class Block_T extends Block
{
	static byte x = 1;
	static byte y = 5;
	static byte [][][] mode_T = 
		{{{0,-1},{-1,0},{0,0},{0,1}},
		 {{-1,-1},{-2,0},{-1,0},{0,0}},
		 {{-1,-1},{-1,0},{-1,1},{0,0}},
		 {{-2,0},{-1,0},{0,0},{-1,1}}};
		
	public Block_T()
	{
		super(x,y,mode_T);
	}
	

}
