import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x = (int)(Math.random()*(850-50+1))+50,y = 450;
	private int vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private boolean collided;
	
	
	  
	
	
	public Duck() {
		img = getImage("cat.drawing.png"); //load the image for Treeduck2.gif
		init(x, y); 				//initialize the location of the image
		 
		vx= (int)(Math.random()*(4-1+1))+1; //random velocity (vx and vy)
		vy= (int)(Math.random()*(4-1+1))+1;
	 vy*=-1; 
	 if(Math.random()<.50 || x<=0||x>=850) {
			vx*=-1;  
		}
		
	} 
 
	public void Duck2() {//tried to make a second duck 
		img = getImage("cat.drawing.png"); //load the image for Treeduck2.gif
		init(x, y); 				//initialize the location of the image
		 
		vx= (int)(Math.random()*(4-1+1))+1;
		vy= (int)(Math.random()*(4-1+1))+1;
	 vy*=-1;
	 if(Math.random()<.50 || x<=0||x>=850) {
			vx*=-1;  
		}
		
	} 
	 
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;  
		
				
		
		  
			
			x+=vx;
			//moving of the duck 
		
			
			 y+=vy;
		
		//x= (int)(Math.random()*700+100);
			//	if(x<=0||x>=850) {
				//	vx*=-1;  
			//	 }
				
		 
		 if (y<=-100||y>=500) { 
			 x = (int)(Math.random()*(850-50+1))+50;
			  y=300; //the duck bounces off of the corners/sides of the frame
			 vx= (int)(Math.random()*(4-1+1))+1; //random velocity
			vy= (int)(Math.random()*(4-1+1))+1;
			vy*=-1; //the duck's velocity y switches to go the other direction
						//if it hits the corners or the sides of frame
			if(Math.random()<.50 || x<=0||x>=850) { 
			vx*=-1; //the vx switches to the other direction
				
			}
			
		 }
	if (x<=0||x>=850) {
		vx*=-1;//used this code just in case, for some reason it works better
 }
	tx.setToTranslation(x, y);//must call this any time and update x and y
	g2.drawImage(img, tx, null); 
	}
		  
	
	Music bang= new Music("Bang.wav",false); //creating the objects for music
	Music haha= new Music("HaHa.wav",false);
	
	
	
	 
	public boolean collided(int mX, int mY) {
		Rectangle m= new Rectangle(x,y,150,150); //size of the animal/duck
		if(m.contains(mX, mY)) {
			System.out.println("ouch");//if it hits, print ouch.
			
			System.out.println(mX+":"+mY);//takes in location of mouse in terms of x and y
			//return false;
			// return true;  
		}else {
			System.out.println("wow");//print wow otherwise
			  
			//have the duck fall from the sky after a hit
			//if it misses, play "haha"
		//System.out.println(mX+":"+mY);//takes in location of mouse in terms of x and y
		//return false;
		}
		return false;
		
		
		
			
		}
	
		public boolean getCollided() {
			return collided; //get and return the collided variable
		}
	
	private static boolean intersects(Rectangle m) {
		// TODO Auto-generated method stub
		return false;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	
	

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public void update() {
	tx.setToTranslation(x, y);
	tx.scale(.4, .4);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ouch"); 
		//figure out how to get the data to the object that needs it
		arg0.getX(); //x and y location getter example
		arg0.getY();
		//Rectangle m = new Rectangle(arg0.getX(),arg0.getY(),50,50);
		//getting the rectangle
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
