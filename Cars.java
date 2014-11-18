import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.AffineTransformOp;

public class Cars extends JPanel implements ActionListener, KeyListener {

    static BufferedImage blue1;
    static BufferedImage blue2;
    static BufferedImage redCar;
    static BufferedImage redCar2;
    static BufferedImage road;

    public KeyBindings input;

    Timer t = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;
    int xr = 0, yr = 0, velXr = 0, velYr = 0;

    public Cars(BufferedImage img,BufferedImage img2,BufferedImage red,BufferedImage red2,BufferedImage roadimg){
      t.start();
      addKeyListener(this);
      this.setFocusable(true);
      setFocusTraversalKeysEnabled(false);

        blue1 = img;
        blue2 = img2;

        redCar = red;
        redCar2 = red2;

        road = roadimg;

        this.addKeyListener(this);

    }
    public Cars(){

    }

    public int setspeedX(){
      if(x == 380){
      velY = velY+2;
      return velY;
    }
    if (x == 15){
      velY = velY-2;
      return velY;
    }
    else
    return velY;
    }
    public int setspeedY(){
      if(y == 5){
      velX = velX+2;
      return velX;
    }
    if (y == 235){
      velX = velX-2;
      return velX;
    }
    else
    return velY;
    }

	public void paintComponent(Graphics g)
	{

	super.paintComponent(g);
  Graphics2D g2d = (Graphics2D) g;

    g2d.drawImage(road,null,5,0);

    if(velXr >= 1 || velXr <= -1)
    g2d.drawImage(redCar2,null,xr,yr);

    else if(velYr <= -1 || velYr >= 1)
    g2d.drawImage(redCar,null,xr,yr);

    if(velX >= 1 || velX <= -1)
    g2d.drawImage(blue2,null,x,y);

    else if(velY >= 1 || velY <= -1)
    g2d.drawImage(blue1,null,x,y);

    else if(velX == 0)
    g2d.drawImage(blue2,null,x,y);

    else if(velY == 0)
    g2d.drawImage(blue1,null,x,y);

    else if(velYr == 0)
    g2d.drawImage(redCar,null,x,y);

    else if(velXr == 0)
    g2d.drawImage(redCar2,null,x,y);

	}

    public void actionPerformed(ActionEvent e){
        repaint();
        x += velX;
        y += velY;

        xr += velXr;
        yr += velYr;
        checkOOB();
}

private void checkOOB() {
  if(x > 380) {x = 380;down1();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -blue1.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  blue1 = op.filter(blue1, null);}

  if(y < 5)  {y = 5;right1();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-blue2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  blue2 = op.filter(blue2, null);}

  if(y > 235) {y = 235; left1();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-blue2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  blue2 = op.filter(blue2, null);
}

  if(x < 15)  {x = 15; up1();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -blue1.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  blue1 = op.filter(blue1, null);}

////////////////////////////////////////////////////////////////////////////////////////////

if(xr > 355) {xr = 355;down();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -redCar.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  redCar = op.filter(redCar, null);
}

if(yr < 26)  {yr = 26;right();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-redCar2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  redCar2 = op.filter(redCar2, null);}

if(yr > 210) {yr = 210; left();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-redCar2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  redCar2 = op.filter(redCar2, null);
}

if(xr < 40)  {xr = 40; up();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -redCar.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  redCar = op.filter(redCar, null);
}

}

    public void up1(){
        velY = -1;
        velX = 0;

    }

    public void down1(){
        velY = 1;
        velX = 0;

    }

    public void left1(){
        velX = -1;
        velY = 0;

    }

    public void right1(){
        velX = 1;
        velY = 0;
    }

    public void up(){

        velYr = 1;
        velXr = 0;
    }

    public void down(){

        velYr = -1;
        velXr = 0;
    }

    public void left(){

        velXr = 1;
        velYr = 0;
    }

    public void right(){

        velXr = -1;
        velYr = 0;
    }

    public void stop(){
      velX = 0;
      velY = 0;

      velXr = 0;
      velYr = 0;
    }

    public void start(){

      velX = 1;
      velY = 0;

      velXr = 1;
      velYr = 0;
    }

     public void keyPressed(KeyEvent e){
       int code = e.getKeyCode();
       if(code == KeyEvent.VK_SPACE)
          stop();
       if(code == KeyEvent.VK_ENTER)
          start();
       if(code == KeyEvent.VK_A)
          setspeedX();
       if(code == KeyEvent.VK_D)
          setspeedY();
        }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
    }
}
