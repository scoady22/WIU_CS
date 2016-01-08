import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class Snake extends Applet implements KeyListener{
	int width, height, direction = 2, x, y, xPos, yPos, score = -10, snakeSize =0;
	boolean isNotOver = true, hasBeenEaten = true;
	Point A = new Point();
	Point B = new Point();
	Random r = new Random();
	Vector<Point> listOfPositions = new Vector<Point>();
	 
	public void init() {
		
		  width = 300;
	      height = 300;
		  setSize(width + 1, height + 1);
		  setBackground( Color.white );
	      setFocusable( true );
	      x = width/2;
	      y = height/2;
	      setRandomDot();
	       
	      addKeyListener( this );
	}
	
	public void start(){
		while(isNotOver = true){
						
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			continueMove();
			repaint();
		}
		
	}
	
	public void stop(){
		
	}
	public void keyPressed( KeyEvent e ) { 
		
		switch(e.getKeyCode())
		    {
		    	case KeyEvent.VK_DOWN:		
		    		if (direction != 1){
		    		y += 10;
		    		}
		    		
		    		if(y > height - 10 ){
						y = 0;
					}
		    		direction = 3;
				break;
					
		    	case KeyEvent.VK_UP:		
		    		if(direction != 3){
		    		y -= 10;
		    		}
		    		
		    		if(y < 10){
						y = height - 10;
					}
		    		direction = 1;
				break;
		    	
		    	case KeyEvent.VK_LEFT:	
		    		if(direction != 2){
		    		x -= 10;
		    		}
		    		
		    		if(x < 10){
						x = width - 10;
					}
		    		direction = 4;
				break;
		    	
		    	case KeyEvent.VK_RIGHT:		
		    		if(direction != 4){
		    		x += 10;
		    		}
		    		
		    		if(x > width - 10 ){
						x = 0;
					}
		    		direction = 2;
				break;
			
		    	default:
		    	break;
		    }
		
		shiftSnake();
		checkCollision();
		 
	}
	public void keyReleased( KeyEvent e ) { }
	public void keyTyped( KeyEvent e ) { }

	
	public void mouseClicked(MouseEvent arg0) { }
	public void mouseEntered(MouseEvent arg0) {	}
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }

	public void paint( Graphics g ) {
		 
		
		 g.setColor(Color.blue);
		 g.drawRect(0, 0, width, height);	 
		 
		 B = (Point)(listOfPositions.elementAt(listOfPositions.size() - 1));
		 g.setColor( Color.black );
	      
		 int size = listOfPositions.size();
		 if( size > 1){
			  for ( int j = 0 ; j < listOfPositions.size() - 1; ++j ) {
				  A = (Point)(listOfPositions.elementAt(j));
				  g.fillRect(A.x, A.y, 10, 10);
			  }
		 }
	      
		 g.setColor( Color.gray);
		 g.fillRect(B.x, B.y, 10, 10);
		  
		 g.setColor ( Color.red );
		 g.fillRect(xPos, yPos, 10, 10);
		  
		 g.setColor( Color.RED );
		 g.drawString(Integer.toString(score), 10, 10);
		  

	}
		
	public void setRandomDot(){
		snakeSize += 1;
		score += 10;
		xPos = r.nextInt(30);
		yPos = r.nextInt(30);
	    xPos = xPos * 10;
		yPos = yPos * 10;
		hasBeenEaten = false;
	}
		
	public void continueMove(){
				
		switch(direction){
			case 1:
				y -= 10;
				
				if(y < 0){
					y = height;
				}
			break;
		
			case 2:
				x+= 10;
				
				if(x >= width ){
					x = 0;
				}
			break;
			
			case 3:
				y +=10;
				
				if(y >= height ){
					y = 0;
				}
			break;
					
		    case 4:
				x -= 10;
				
				if(x < 0){
					x = width;
				}
			break;
		
			default:
		    break;
		}
		
		shiftSnake();		
		checkCollision();
	}
	
	public void checkCollision(){
	 B = (Point)(listOfPositions.elementAt(listOfPositions.size() - 1));
	 int[][] array = new int[2][snakeSize];
	 for ( int j = 0 ; j < listOfPositions.size() - 1; ++j ) {
		  array[0][j] = A.x;
		  array[1][j] = A.y;
		      
		  if(B.x == array[0][j] && B.y == array[1][j]){
			  isNotOver = false;
		  }
	}
	
	}
	
	
	public void shiftSnake(){
		if ( listOfPositions.size() >= snakeSize ) {
	         // delete the first element in the list
	         listOfPositions.removeElementAt( 0 );
		}  
	    
		listOfPositions.addElement( new Point( x, y ) );
	 		
	 	if(x == xPos && y == yPos){
	 		hasBeenEaten = true;
	 		setRandomDot();
	 	}
	}
}


