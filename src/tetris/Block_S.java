package tetris;

public class Block_S extends Block
{
	static byte x = 1;
	static byte y = 5;
	static byte [][][] mode_S = 
		{{{0,-1},{0,0},{-1,0},{-1,1}},
		 {{-2,-1},{-1,-1},{-1,0},{0,0}},
		 {{0,-1},{0,0},{-1,0},{-1,1}},
		 {{-2,-1},{-1,-1},{-1,0},{0,0}}};
		
	public Block_S()
	{
		super(x,y,mode_S);
	}

}
