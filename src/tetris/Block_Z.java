package tetris;

public class Block_Z extends Block
{
	static byte x = 1;
	static byte y = 6;
	static byte [][][] mode_Z = 
		{{{-1,-1},{-1,0},{0,0},{0,1}},
		 {{-2,1},{-1,1},{-1,0},{0,0}},
		 {{-1,-1},{-1,0},{0,0},{0,1}},
		 {{-2,1},{-1,1},{-1,0},{0,0}}};
		
	public Block_Z()
	{
		super(x,y,mode_Z);
	}

}
