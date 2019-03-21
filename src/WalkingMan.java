import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class WalkingMan extends JComponent
{
	//field
	private Ellipse2D.Double head;
	private Rectangle2D.Double arms;
	private Rectangle2D.Double torso;
	private Rectangle2D.Double hips;
	private Rectangle2D.Double leftLeg;
	private Rectangle2D.Double rightLeg;
	private int dx = 0, dy = 0;
	
	//constructor
	public WalkingMan()
	{
		head = new Ellipse2D.Double(15,0,25,25);
		arms = new Rectangle2D.Double(0,25,55,10);
		torso = new Rectangle2D.Double(15,25,25,40);
		leftLeg = new Rectangle2D.Double(15,65,8,20);
		rightLeg = new Rectangle2D.Double(32,65,8,20);
		this.setSize(200,200);
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(head);
		g2.fill(arms);
		g2.fill(torso);
		g2.fill(leftLeg);
		g2.fill(rightLeg);
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
	
	public void setDX(int dx)
	{
		this.dx = dx;
	}
	
	public void setDY(int dy)
	{
		this.dy = dy;
	}
	
	public int getWidth()
	{
		return (int) arms.getWidth();
	}
	
	public int getHeight()
	{
		return (int) (head.getHeight() + arms.getHeight() + torso.getHeight() + leftLeg.getHeight());
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public int getDY()
	{
		return dy;
	}
}
