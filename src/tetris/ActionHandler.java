package tetris;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class ActionHandler implements KeyListener
{
	@Override 
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'w' || e.getKeyCode()==KeyEvent.VK_UP)
		{
			Data.block.change();
		}
		if(e.getKeyChar() == 'a' || e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			Data.block.left();
		}
		if(e.getKeyChar() == 's' || e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			Data.block.down();
		}
		if(e.getKeyChar() == 'd' || e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			Data.block.right();
		}
		if(e.getKeyChar() == 'z')
		{
			if(Data.player==1)
				Data.player=0;
			else
			{
				Player.solve();
				Data.player=1;
			}
				
		}
		if(e.getKeyChar() == 'p')
		{
			Data.pause = !Data.pause;
		}
		if(e.getKeyChar() == 'j')
		{
			Data.dealy = 1000;
		}
		if(e.getKeyChar() == 'k')
		{
			Data.dealy = 100;
		}
		if(e.getKeyChar() == 'l')
		{
			Data.dealy = 10;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
