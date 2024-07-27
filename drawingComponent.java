
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;



public class drawingComponent extends JPanel implements ActionListener,KeyListener {
	
	double x=200;
	double y=200;
	double velX=0;
	double velY=0;
	Timer t = new Timer(5,this);
	static Timer timer;
	int directionX=1;
	double xMove=5;
	int directionY=1;
	double yMove=5;
	double width=40;
	double height=40;
	Ellipse2D.Double circle;
	Rectangle.Double rect;
	Random rnd=new Random();
	double a=rnd.nextInt(800);
	double b=rnd.nextInt(600);
	Square square;
	Square[] squares=new Square[3];



	
	
	public drawingComponent() {
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		createSquares();
		
	
	}
	
	@Override
		 public void paintComponent(Graphics g) {
		

				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
			
                     drawSquares(g2);
					
				}
				
			
		 
	public void drawSquares(Graphics2D g) {
		for (int i=0;i<squares.length;i++) {
			
			squares[i].draw(g);
			
		}
			
		}
		 
		 public void createSquares() {
				
				for (int i=0;i<squares.length;i++) {
					x-=40;
					squares[i]=new Square(x, y);
					squares[i].particleName=Integer.toString(i);
					if (i>0) {
						squares[i-1].next=squares[i];
					}

					
				}
			}
		 public void up() {
			 for(int i=0;i<squares.length;i++) {
				 squares[i].directionY*=-1;
					squares[i].xMove=0;
					squares[i].yMove=1;
					
			 }	
			
		}
				
			public void down() {
				for(int i=0;i<squares.length;i++) {
					squares[0].y+=4.5;
					squares[0].xMove=0;
					squares[0].directionY*=-1;
					squares[0].yMove=1;

					if(squares[i].directionY==-1) {
						squares[i+1].x+=squares[i+1].width;
						//if(squares[i+1].x==squares[0].x) {
							squares[i+1].directionY*=-1;
							squares[i+1].xMove=0;
							squares[i+1].yMove=1;
							//squares[2].y-=4.5;
	                        //squares[2].x+=4.5;
							repaint();
							

						}
					
						

						

				}
					
						
			}
			
			public void downCheck() {
				for(int i=0;i<squares.length;i++) {
					//squares[2].y-=4.5;
                       // squares[2].x+=4.5;
                          }
				}
			
					
					
					
				
					
					
					
				
					
				
				
				
				

			
			public void left() {
				for(int i=0;i<squares.length;i++) {
					if(squares[i].yMove>0) {
						squares[i].xMove=1;
						squares[i].yMove=0;
				      if(squares[i].directionX>0) squares[i].directionX*=-1;
					}


				}
				
				
			}
			public void right() {
				if(yMove>0) {
					xMove=1;
					yMove=0;
				      if(directionX<0) directionX*=-1;

				}

			}
			
			public void moveX() {
				for(int i=0;i<squares.length;i++) {
				squares[i].x+=squares[i].xMove*squares[i].directionX;
				if(squares[i].x<=0 || squares[i].x>=800) {
					squares[i].directionX*=-1;
					}
			}
			}
			
			public void moveY() {
				for(int i=0;i<squares.length;i++) {

					squares[i].y+=squares[i].yMove*squares[i].directionY;
				if(squares[i].y<=0 || squares[i].y>=600) {
					squares[i].directionY*=-1;
					}
				}		
			}
		 
		
		 
		 
			
			public void keyPressed(KeyEvent e) {
				int code=e.getKeyCode();
				System.out.println("Up pressed in panel" + code);

				if(code==38) {
				for (int i=0;i<squares.length;i++) {

					up();
				}
				
			}
				if(code==40) {
					for (int i=0;i<squares.length;i++) {
				down();
				
				}
			}
				if(code==37) {
					for (int i=0;i<squares.length;i++) {
					left();

				}
			}
				if(code==39) {
					for (int i=0;i<squares.length;i++) {
	                   right();

					}
                    
                    
				}
				
				if(code==32) {
                    timer.start();
                    
                    
				}
                    
				
			}
			
			
			
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			
			public void actionPerformed(ActionEvent e) {
				

			timer=new Timer(20, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<squares.length;i++) {
					if(squares[i].xMove>0) {
                        moveX();
                        repaint();
					}
					}
					
					   
					for(int i=0;i<squares.length;i++) {
						if(squares[i].yMove>0) {
	                        moveY();
	                        repaint();
	                     
						}
					 
					   
					}
                     	
			};
	
		
	
	 
	
			
	});


}

}




			


			



