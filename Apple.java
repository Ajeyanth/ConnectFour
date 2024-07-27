import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.Random;

public class Apple {
	Random rnd=new Random();

	double a;
	double b;
	
	Ellipse2D.Double apple;
	double width=40;
	double height=40;;
	double totalLength=0;
    
	
	public Apple() {
		a=rnd.nextInt(500);
		b=rnd.nextInt(500);
		
		int remainder=(int) (a%25);
		a-=remainder;
		
		remainder=(int) (b%25);
		b-=remainder;
	}
	
	public void drawApple(Graphics2D g) {
		apple=new Ellipse2D.Double(a, b, 25, 25);
		g.setColor(Color.RED);
		g.draw(apple);
		g.fill(apple);
	}
	
	
	public void newApple() {
		apple=new Ellipse2D.Double(a,b,25,25);
	}

	
	
	


}
