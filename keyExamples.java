import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics; 
import java.util.Random;


  public class keyExample extends JPanel implements ActionListener, KeyListener{
    Timer t = new Timer(5, this);
    double x = 0, y = 0;
   
    double changeX = 0, changeY = 0;

    public keyExample() {
      t.start();
      addKeyListener(this);
      
      setFocusable(true);
     
      setFocusTraversalKeysEnabled(false);

    }
	private static final int N_CIRCLES = 10;

	private static final double MIN_RADIUS = 5;
	
	private static final double MAX_RADIUS = 50;
	
	public void run() { 
	Random gen = new Random();
		
	for (int i = 0; i < N_CIRCLES; i++) {
	
	double range = MAX_RADIUS - MIN_RADIUS;
	double r = MIN_RADIUS + (gen.nextDouble() * range);
	
	double r = gen.nextDouble(MIN_RADIUS, MAX_RADIUS);
	double x = gen.nextDouble(0, getWidth() - 2 * r);
	double y = gen.nextDouble(0, getHeight() - 2 * r);
	
	Circle circle = new Circle(x, y, 2 * r, 2 * r);
	circle.setFilled(true);
	
	
	int red = gen.nextInt(256);
	int green = gen.nextInt(256);
	int blue = gen.nextInt(256);
	
	Color backColor = new Color(red, green, blue);
	
	pane.add(panel);

	}
	add(circle);
	}

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
    
      
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.BLUE);
      g2.fill(new Rectangle2D.Double(x, y, 40, 40));
      
		Rectangle box1 = new Rectangle(5, 10, 20, 30);
		Rectangle box2 = new Rectangle(25, 10, 20, 30);
		Rectangle box3 = new Rectangle(45, 10, 20, 30);
		
		g2.draw(box1);
		g2.draw(box2);
		g2.draw(box3);
	
      
    }
    

    public void actionPerformed(ActionEvent e) {
      repaint();
      x += changeX;
      y += changeY;
      changeX = 0;
      changeY = 0;
    }

    public void up() {
      if (y != 0){
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
      if (x >=0) {
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
   
    public void keyTyped(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
			

  }
