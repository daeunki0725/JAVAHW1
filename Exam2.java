import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Container;

import java.util.Random;

public class Exam2 extends JFrame {

      public Exam2() {
      

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500, 500);
            
            getContentPane();
            
            setVisible(true);	

            setLayout(null);

            
            Circle lips = new Circle(60, 60, 60, Color.RED);
            Circle eyes1 = new Circle(12, 100, 40, Color.BLACK);
            Circle eyes2 = new Circle(120, 170, 40, Color.BLACK);


            add(lips);

            add(eyes1);

            add(eyes2);

            setVisible(true);
	
			Random gen = new Random();
	
			for (int i = 1; i <= 1; i++){
			int red = gen.nextInt(256);
			int green = gen.nextInt(256);
			int blue = gen.nextInt(256);
			Color backColor = new Color(red, green, blue);

			Circle body = new Circle(130, 200, 210, backColor);
			            
            add(body);

			}
			

      }

      public static void main(String[] args) {

            new Exam2();

      }

}


class Circle extends JComponent implements MouseMotionListener, MouseListener {

      Color color;

      boolean beingDragged = false;

      int offsetX, offsetY;

      public Circle(int x, int y, int radius, Color color) {
            setBounds(x, y, radius * 2, radius * 2);
            this.color = color;
            addMouseMotionListener(this);
            addMouseListener(this);

      }

      @Override

      public void mouseDragged(MouseEvent e) {

            if (beingDragged) {
            
                  setBounds(e.getXOnScreen() - offsetX, e.getYOnScreen() - offsetY,
                              getWidth(), getHeight());

            }

      }

      @Override

      public void mouseMoved(MouseEvent arg0) {

      }

      @Override

      protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            g.setColor(color);
            g.fillOval(10, 10, getWidth() - 20, getHeight() - 20);

      }

      @Override

      public void mouseClicked(MouseEvent arg0) {

      }

      @Override

      public void mouseEntered(MouseEvent arg0) {

      }

      @Override

      public void mouseExited(MouseEvent arg0) {

      }

      @Override

      public void mousePressed(MouseEvent e) {

            if (!beingDragged) {
            
                  offsetX = e.getXOnScreen() - getX();
                  offsetY = e.getYOnScreen() - getY();
                  beingDragged = true;

            }

      }

      @Override

      public void mouseReleased(MouseEvent arg0) {
            offsetX = 0;
            offsetY = 0;
            beingDragged = false;

      }

}
