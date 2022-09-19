package tetris;

public class TetrisTimer extends Thread
{
	static int count;
	public void run()
	{
		try {
			this.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true)
		{			
			try {
				if(Data.player==1)
					this.sleep(Data.delay);
				else
					this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!Data.pause)
				Data.block.down();
		}	
	}

}
