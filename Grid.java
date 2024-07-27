import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

public class Grid {
	
	double x1;
	double y1;
	Rectangle.Double square;
	String name;
	double width=100;
	double height=100;
    int direction,nextDirection;
    Grid next;
	Color gridColor;
	int gridNumber;
	boolean filled;
	int column;



	
	public Grid(double x,double y,int gridNumber) {
		
		
		this.x1=x;
		this.y1=y;
		this.gridNumber=gridNumber;
		if (gridNumber%2==0) {
			this.gridColor=new Color(255,255, 255);
		}
		else this.gridColor=new Color(255,255,255);
		this.filled=false;
		if(this.x1==0) {
			this.column=1;
			
		}
		if(this.x1==100) {
			this.column=2;
			
		}
		if(this.x1==200) {
			this.column=3;
			
		}
		if(this.x1==300) {
			this.column=4;
			
		}
		if(this.x1==400) {
			this.column=5;
			
		}
		if(this.x1==500) {
			this.column=6;
			
		}
		if(this.x1==600) {
			this.column=7;
			
		}

		
	
		
	}
	
	public void sketchGrid(Graphics2D g) {
		
		square=new Rectangle.Double(x1, y1, width,height);
		g.setColor(gridColor);
		g.fill(square);
		g.setColor(Color.BLACK);
		g.draw(square);
		//System.out.println(gridNumber);
		
		
	}
	


}