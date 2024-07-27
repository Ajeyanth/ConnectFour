import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class Block {
	double x2;
	double y2;
	Random rnd=new Random();

	
	Rectangle.Double square;
	String name;
	double width=40;
	double height=40;
    int direction,nextDirection;
    SquareNew next;
    int total=0;



	
	public Block(double x2,double y2) {
		
		
		this.x2=x2;
		this.y2=y2;
		
		 x2=rnd.nextInt(500);
		 y2=rnd.nextInt(500);
		//double x2=(squares[0].x+apple.a)/2;
		//double y2=(squares[0].y+apple.b)/2;
		int remainder=(int) (x2%25);
		x2-=remainder;
		remainder=(int) (y2%25);
		y2-=remainder;

		
	
		
	}
	
	
	public void draw(Graphics2D g) {
		square=new Rectangle.Double(x2, y2, 25, 25);	
		
		
		g.draw(square);
		g.fill(square);
	}
	

}
