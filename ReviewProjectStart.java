import javax.swing.JFrame;

public class ReviewProjectStart {
  public static void main(String args[]){
  JFrame theGUI = new JFrame();
  keyExample s = new keyExample();
  theGUI.add(s);
  theGUI.setVisible(true);
  theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  theGUI.setSize(600,400);
}
}
