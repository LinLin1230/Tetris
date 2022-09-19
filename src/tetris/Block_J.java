package tetris;

public class Block_J extends Block
{
	static byte x = 1;
	static byte y = 5;
	static byte [][][] mode_J = 
		{{{-1,-1},{0,-1},{0,0},{0,1}},
		 {{0,-1},{0,0},{-1,0},{-2,0}},
		 {{-1,-1},{-1,0},{-1,1},{0,1}},
	     {{-2,0},{-1,0},{0,0},{-2,1}}};
		
	public Block_J()
	{
		super(x,y,mode_J);
	}

}
