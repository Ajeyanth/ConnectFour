import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Square {
	
	double x=200;
	double y=200;
	
	int directionX=1;
	double xMove=1;
	int directionY=-1;
	double yMove=0;
	Rectangle.Double square;
	String particleName;
	double width=40;
	double height=40;
	
	Square next;
	int direction;




	
	public Square(double x,double y) {
		
		this.x=x;
		this.y=y;
		
	
		
	}
	
	public void draw(Graphics2D g) {
		square=new Rectangle.Double(x, y, width, height);
		g.drawString(particleName, (int)this.x+20, (int)this.y+20);

		g.draw(square);
	}
	
	
	
	


	



}
