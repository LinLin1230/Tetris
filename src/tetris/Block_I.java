package tetris;

public class Block_I extends Block
{
	static byte x = 1;
	static byte y = 4;
	static byte [][][] mode_I = 
		{{{0,-1},{0,0},{0,1},{0,2}},
		 {{1,0},{0,0},{-1,0},{-2,0}},
		 {{0,-1},{0,0},{0,1},{0,2}},
		 {{1,0},{0,0},{-1,0},{-2,0}}};
		
	public Block_I()
	{
		super(x,y,mode_I);
	}

}
