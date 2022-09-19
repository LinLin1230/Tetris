package tetris;

public class Block_O extends Block
{
	static byte x = 1;
	static byte y = 4;
	static byte [][][] mode_O = 
		{{{-1,0},{0,0},{-1,1},{0,1}},
		 {{-1,0},{0,0},{-1,1},{0,1}},
		 {{-1,0},{0,0},{-1,1},{0,1}},
		 {{-1,0},{0,0},{-1,1},{0,1}}};
		
	public Block_O()
	{
		super(x,y,mode_O);
	}

}
