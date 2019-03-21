import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Frame extends JFrame implements ActionListener 
{
	WalkingMan man = new WalkingMan();
	ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public Frame()
	{	
		setBounds(500,100,800,600);
		setLayout(null);
		
		man.setLocation(getWidth()/2 - man.getWidth()/2, getHeight()/2 - man.getHeight()/2);
		add(man);
		
		addKeyListener(new KeyListener ()
			{
				public void keyPressed(KeyEvent e)
				{
					if(e.getKeyCode() == e.VK_W)
					{
							man.setDY(-5);
					}
					else if(e.getKeyCode() == e.VK_S)
					{	
							man.setDY(5);
					}
					else if(e.getKeyCode() == e.VK_A)
					{
						man.setDX(-5);
					}
					else if(e.getKeyCode() == e.VK_D)
					{
						man.setDX(5);
					}
					else if(e.getKeyCode() == e.VK_SPACE)
					{
						Ball ball = new Ball(man.getX() + man.getWidth()/2, man.getY() + man.getHeight()/4);
						balls.add(ball);
						ball.setDX(ball.getDX() + man.getDX()/2);
						ball.setDY(ball.getDY() + man.getDY()/2);
						add(ball);
					}
				}
				
				public void keyReleased(KeyEvent e)
				{
					if(e.getKeyCode() == e.VK_W)
					{
						man.setDY(0);
					}
					else if(e.getKeyCode() == e.VK_S)
					{
						man.setDY(0);
					}
					else if(e.getKeyCode() == e.VK_A)
					{
						man.setDX(0);
					}
					else if(e.getKeyCode() == e.VK_D)
					{
						man.setDX(0);
					}
				}
				
				public void keyTyped(KeyEvent arg0) {}
			
			});
		
		Timer timer = new Timer(50/3, this);
		timer.start();
		
		man.setFocusable(false);
		setFocusable(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		man.update();
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).update();
			if (balls.get(i).getX() > this.getWidth() - balls.get(i).getWidth() || balls.get(i).getY() > this.getHeight() - balls.get(i).getHeight())
			{	
				balls.remove(i);
				i--;
			}
		}
		fixBounds(man);
		repaint();
	}
	
	public void fixBounds(WalkingMan man)
	{
		if (man.getX() < 0)
			man.setLocation(0, man.getY());
		
		if (man.getY() < 1)
			man.setLocation(man.getX(), 1);
		
		if (man.getX() >= this.getWidth() - man.getWidth() - 17)
			man.setLocation(this.getWidth() - man.getWidth() - 17, man.getY());
		
		if (man.getY() >= this.getHeight() - man.getHeight() - 30)
			man.setLocation(man.getX(), this.getHeight() - man.getHeight() - 30);
	}
	
	public static void main(String[] args)
	{
		Frame frame = new Frame();
	}
}

