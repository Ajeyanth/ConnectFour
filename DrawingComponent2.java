
import java.awt.Color;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;







public class DrawingComponent2 extends JPanel implements KeyListener {
	
	double x=200;
	double y=200;
	static Timer timer,timer1,timer2;
	double width=20;
	double height=20;
	Rectangle.Double rect;
	Random rnd=new Random();
	SquareNew square;
	Apple apple;
	Apple apple2;
	int totalLength=2;
	SquareNew[] squares=new SquareNew[500];
	int totalBlocks=0;
	Block[] blocks=new Block[500];
	int moveDirection;
	SquareNew ghost=new SquareNew(300,300);
	Grid[][] grid = new Grid[20][20];
	Timer[] timers= new Timer[500];
	int totalTimers=1;
	boolean right;
	boolean left;
	boolean up;
	boolean down;
	boolean dead=false;
	Polygon polygon;
    double x1=0;
    double y1=0;
    int r;
    boolean useApple=true;
    boolean useBlock=true;
    boolean useClassic=true;
    boolean useSpeed=true;
    boolean useArcade=true;
    boolean useEndless=true;
    int speed=150;

    
	
	

	
	public DrawingComponent2() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		
		
		createGrid();

	
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawGrid(g2);
		
	}

	
	
	
	
	public void drawGrid(Graphics2D g) {
		for (int i=0;i<7;i++) {
        for (int j=0;j<6;j++) {
			grid[i][j].sketchGrid(g);

			
		}
		}
	
	}

	
	
	
	public void createGrid() {
		for (int i=0;i<7;i++) {
			y1=0;
		for (int j=0;j<6;j++) {
			grid[i][j]=new Grid(x1, y1,(7*j)+i);
			System.out.println(grid[i][j].gridNumber);
			y1+=100;
	
					
		}
		x1+=100;
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
			

}




			


			



