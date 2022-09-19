package tetris;
import java.awt.Toolkit;
import javax.swing.*;


public class MainFrame extends JFrame
{
	static TetrisPanel TPanel = new TetrisPanel();
	static ControlPanel CPanel = new ControlPanel();
	static ActionHandler handler= new ActionHandler();
	public MainFrame()
	{
		addKeyListener(handler);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-100,Toolkit.getDefaultToolkit().getScreenSize().height/2-200,400,490);
		Data.initial();
		TPanel.setBounds(0, 0, 200, 440);//
		TPanel.setBackground(java.awt.Color.white);
		add(TPanel);
		CPanel.setBounds(200, 0, 200, 440);
		add(CPanel);
		setVisible(true);		
		refresh();
	}
	public static void refresh()
	{
		Data.displayMatrixRefresh();
		TPanel.repaint();
		CPanel.repaint();
	}
	public static void main(String args[])
	{
		new TetrisTimer().start();
		new MainFrame();	
	}

}
