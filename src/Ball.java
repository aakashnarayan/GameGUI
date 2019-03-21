import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	//field
	private Ellipse2D.Double ball;
	private int dx = 8, dy = 0;
	
	//constructor
	public Ball(int x, int y)
	{
		ball = new Ellipse2D.Double(0,0,10,10);
		this.setSize(11,11);
		this.setLocation(x, y);
	}
	
	//methods
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(ball);
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public void setDX(int dx)
	{
		this.dx = dx;
	}
	
	public void setDY(int dy)
	{
		this.dy = dy;
	}
}
