import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;

public class DisplayClass
{
  public static Cars panel;
  public static KeyBindings input2;

  public DisplayClass(){
  }

  public static void main(String[]agrs)throws java.io.IOException
  {
  BufferedImage blueCar = ImageIO.read(new File("blueCar.png"));
  BufferedImage blueCar2 = ImageIO.read(new File("blueCar2.png"));

  BufferedImage redCar = ImageIO.read(new File("redCar.png"));
  BufferedImage redCar2 = ImageIO.read(new File("redCar2.png"));

  BufferedImage road = ImageIO.read(new File("road.jpg"));

  final  JPanel panelRoad = new JPanel();

  JFrame frame = new JFrame("CAR SIMULATOR");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(700,400);

  Container pane = frame.getContentPane();
  panel = new Cars(blueCar,blueCar2,redCar,redCar2,road);
  pane.add(panel);

  frame.setVisible(true);
  }
}
