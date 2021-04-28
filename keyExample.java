import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class keyExample extends JPanel implements ActionListener, KeyListener {

  Timer t = new Timer(5, this);
  double x = 0, y = 30;
  double changeX = 0, changeY = 0;
  int f = 0, i = 0;

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

    int diameter;
    double x;

    Random generator = new Random();

    if (i == 8) {
      i = 0;
    }

    diameter = generator.nextInt(60) + 20;

    g2.setColor(new Color(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)));
    x = (double) i / 7 * (double) 400;
    g2.fill(new Ellipse2D.Double((int) x, 30, diameter, diameter));
    
    i++;
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
