import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.time.ZonedDateTime;

public class keyExample extends JPanel implements ActionListener, KeyListener {

  Timer t = new Timer(5, this);
  double x = 0, y = 30;
  double changeX = 0, changeY = 0;
  int f = 0;
  int[][] values = new int[7][6];
  int lives = 3;
  long time = ZonedDateTime.now().toInstant().toEpochMilli();
  boolean gameover = false;
  
  public static void main(String args[]) {
    JFrame theGUI = new JFrame();
    keyExample s = new keyExample();
    theGUI.add(s);
    theGUI.setVisible(true);
    theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theGUI.setSize(600, 400);
  }

  public keyExample() {

    t.start();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    setValues(0, 7);
  }

  private void setValues(int start, int finish) { 
    Random generator = new Random();
    for (int i = start; i < finish; i++) { 
        values[i][0] = generator.nextInt(60) + 20; // size 
        values[i][1] = 0; // position at zero always
        values[i][2] = generator.nextInt(2) + 1; // speed can be between 2 < x < 4
        values[i][3] = generator.nextInt(256); // R
        values[i][4] = generator.nextInt(256); // G
        values[i][5] = generator.nextInt(256); // B
    } 
  } 
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    	
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.BLUE);
    g2.fill(new Rectangle2D.Double(x, y, 40, 40));
    
    if (gameover == true) {
      
    g2.drawString("GAME OVER LOSER", 200, 200);
    
    if (ZonedDateTime.now().toInstant().toEpochMilli() - time > 3000) 
    
    System.exit(0);
    }
    
    if (checkHit() && ZonedDateTime.now().toInstant().toEpochMilli() - time > 5000) { 
    	System.out.println("HIT");
    	
    	lives--;
    	
    	time = ZonedDateTime.now().toInstant().toEpochMilli();
    	
    	if (lives == 0){
    	
    	 gameover = true;

    	}
    	}
    
    for (int i = 0; i < lives; i++) {
		
    Rectangle box = new Rectangle(i*20+5, 10, 20, 30);
    
    g2.draw(box);
    
    }
    
    double x;

    for (int i = 0; i < 7; i++) {
        g2.setColor(new Color(values[i][3], values[i][4], values[i][5]));
        x = (double) i / 7 * (double) 600;
        values[i][1] += values[i][2];
        g2.fill(new Ellipse2D.Double(x, values[i][1], values[i][0], values[i][0]));
        
        if (values[i][1] >= 400) setValues(i, i + 1); 
    }
  }
	private boolean checkHit() { // function to check hit - you have write this!
	
	for (int i = 0; i < 7; i++) {
		double y1 = i / 7*600;
		double x1 = values[i][1];
		
		double distance = Math.pow(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2), 1/2);
		double threshold = 20 + (double)values[i][0]/2;
		
		if (distance < threshold)
		return true;
		}
		return false;
	}
  public void actionPerformed(ActionEvent e) {
    Scanner sc = new Scanner(System.in);
    repaint();
    x += changeX;
    y += changeY;
    changeX = 0;
    changeY = 0;
  }

  public void up() {
    if (y != 0) {
      changeY = -3.5;
      changeX = 0;
    }
  }

  public void down() {
    if (y <= 350) {
      changeY = 3.5;
      changeX = 0;
    }
  }

  public void left() {
    if (x >= 0) {
      changeX = -3.5;
      changeY = 0;
    }
  }

  public void right() {
    if (x <= 550) {
      changeX = 3.5;
      changeY = 0;
    }
  }

  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_UP) {
      up();
    }

    if (code == KeyEvent.VK_DOWN) {
      down();
    }

    if (code == KeyEvent.VK_RIGHT) {
      right();
    }

    if (code == KeyEvent.VK_LEFT) {
      left();
    }
  }

  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}
}
