import java.awt.AlphaComposite;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class SquareNew {
	
	double x;
	double y;
	
	Rectangle.Double square;
	RoundRectangle2D.Double square1;
	RoundRectangle2D.Double square2;


	String name;
	double width=40;
	double height=40;
    int direction,nextDirection;
    SquareNew next;
    double totalLength=2;
    boolean collision=false;
    int totalBlocks=0;
   
	Color squareColor= Color.green;



	
	public SquareNew(double x,double y) {
		
		
		this.x=x;
		this.y=y;
		

		
	
		
	}
	
	public void draw(Graphics2D g) {
		square=new Rectangle.Double(x, y, 20, 20);
		square1=new RoundRectangle2D.Double(x, y, 25, 25,15,15);
	
		
		//g.drawString(name, (int)this.x+10, (int)this.y+10);
		
        g.setColor(squareColor);
		g.draw(square1);
		g.fill(square1);
		g.setComposite(AlphaComposite.SrcOver.derive(0.65f));
	}
	
	
	public void checkCollisionWithApple(Apple apple) {
		
		if(this.x==apple.a && this.y==apple.b) {
			totalLength+=1;
			collision=true;
			if(collision==true) {
				//System.out.println(totalLength);
				//apple.newApple();
				apple= new Apple();
				totalBlocks+=1;
				System.out.println(totalBlocks);
				
				System.out.println(apple.a + "," + apple.b);
				

				
			}

			
		}
		
	}
	
	public void checkCollisionWithBlock(Block[] block) {
		//System.out.println("Method for block");
		//for(int i=0; i<totalBlocks;i++) {
		//	System.out.println(i);
			if(this.x==block[totalBlocks].x2 && this.y==block[totalBlocks].y2) {
				System.out.println("Block");
			}
			
		//}
		  
		
		
		//for(int i =0 ; i<totalBlocks;i++) {
				//System.out.println(totalBlocks);
			//System.out.println(block[i].x2 + "," + block[i].y2);

		   /* if(this.x==block[i].x2 && this.y ==block[i].y2) {
				System.out.println("Collision with block");
				System.out.println(block[i].x2 + "," + block[i].y2);*/


		     //}
		//}
		
		
		
	}

	
	


}
