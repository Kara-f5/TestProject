import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	
	//Objects that need to be drawn on the JFrame in the paint method.
	//1) write the code to create a ground object
	Ground foreground= new Ground(); 
	//2)try the same thing with the tree class
	Tree tree= new Tree();
	Duck duck= new Duck();
	Duck duck2 = new Duck();
	Dog dog= new Dog(); //creating objects for the class
	int counter= 0;
	Music soundBang= new Music("Bang.wav",false);
	Music soundHaha= new Music("HaHa.wav",false);
	public void paint(Graphics g) {
//invoke the paint methods of the foreground and ground objects
		super.paintComponent(g);//refresh the j frame properly
		duck.paint(g);   
		foreground.paint(g); 
		tree.paint(g);  
		dog.paint(g);    
	} 
	 
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt"); 
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this); 
		f.setResizable(false);
		 
		Timer t = new Timer(16, this);
	 
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//when a mouse button is pressed and released
	@Override
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(duck.getCollided()==false) { //counter for duck
			//if the duck isn't collided or hit, then add to the counter
			counter++;
		}
		System.out.println(counter);
		
		if (counter==3) {//once the duck is hit three timees, or when counter is 3, move position of the dog to 
			//the middle
		//dog.setDog(int x){ 
			dog.setDog(300);		
				counter=0;   //reset the counter to 0 after dog is moved	
				}
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
		
		int x= arg0.getX(); //x and y location getter example
		int y= arg0.getY();
		Rectangle m= new Rectangle(x,y,150,150);
		duck.collided(x,y); {;//send x and y to duck object's
		//collision code
		if (m.contains(x, y)) { //play the bang sound if you click and haha if you miss
			soundBang.play();
		}else  {
		
		soundHaha.play();
		} 
		}  
	}

	
	
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
