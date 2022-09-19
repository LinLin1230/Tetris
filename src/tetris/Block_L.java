package tetris;

public class Block_L extends Block
{
	static byte x = 1;
	static byte y = 4;
	static byte [][][] mode_L = 
		{{{0,-1},{0,0},{0,1},{-1,1}},
		 {{-2,-1},{-2,0},{-1,0},{0,0}},
		 {{-1,-1},{0,-1},{-1,0},{-1,1}},
		 {{-2,0},{-1,0},{0,0},{0,1}}};
		
	public Block_L()
	{
		super(x,y,mode_L);
	}

}
