import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.AffineTransformOp;

public class Game extends JPanel implements ActionListener, KeyListener {

    static BufferedImage blue1;
    static BufferedImage blue2;
    static BufferedImage redCar;
    static BufferedImage redCar2;
    static BufferedImage pause;
    static BufferedImage start;

    Timer t = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;
    int xr = 0, yr = 0, velXr = 0, velYr = 0;

    public Game(BufferedImage img,BufferedImage img2,BufferedImage red,BufferedImage red2,BufferedImage stop, BufferedImage startimg){

        t.start();
        addKeyListener(this);
        this.setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        blue1 = img;
        blue2 = img2;

        redCar = red;
        redCar2 = red2;

        pause = stop;
        start = startimg;

        this.addKeyListener(this);
    }

	public void paintComponent(Graphics g)
	{
	super.paintComponent(g);
  Graphics2D g2d = (Graphics2D) g;

 if(velXr == 2|| velXr == -2)
    g2d.drawImage(redCar2,null,xr,yr);
    else if(velYr== 2|| velYr == -2)
    g2d.drawImage(redCar,null,xr,yr);
    if(velX== 2|| velX == -2)
    g2d.drawImage(blue2,null,x,y);
    else if(velY== 2|| velY == -2)
    g2d.drawImage(blue1,null,x,y);

    g2d.drawImage(start,null,190,145);
    g2d.drawImage(pause,null,260,150);

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
  if(x > 400) {x = 400;down();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -blue1.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
blue1 = op.filter(blue1, null);}

  if(y < 10)  {y = 10;right();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-blue2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
blue2 = op.filter(blue2, null);}

  if(y > 200) {y = 200; left();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-blue2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  blue2 = op.filter(blue2, null);
}

  if(x < 100)  {x = 100; up();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -blue1.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
blue1 = op.filter(blue1, null);}

////////////////////////////////////////////////////////////////////////////////////////////

if(xr > 400) {xr = 400;down();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -redCar.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
redCar = op.filter(redCar, null);}

if(yr < 60)  {yr = 60;right();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-redCar2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
redCar2 = op.filter(redCar2, null);}

if(yr > 300) {yr = 300; left();
  AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  tx.translate(-redCar2.getWidth(null), 0);
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  redCar2 = op.filter(redCar2, null);
}

if(xr < 100)  {xr = 100; up();
  AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
  tx.translate(0, -redCar.getHeight(null));
  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
redCar = op.filter(redCar, null);}

}

    public void up(){
        velY = -2;
        velX = 0;

        velYr = -2;
        velXr = 0;
    }

    public void down(){
        velY = 2;
        velX = 0;

        velYr = 2;
        velXr = 0;
    }

    public void left(){
        velX = -2;
        velY = 0;

        velXr = -2;
        velYr = 0;
    }

    public void right(){
        velX = 2;
        velY = 0;

        velXr = 2;
        velYr = 0;
    }
    public void stop(){
      velX = 0;
      velY = 0;

      velXr = 0;
      velYr = 0;
    }

    public void start(){

      velX = 2;
      velY = 0;

      velXr = 2;
      velYr = 0;
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SPACE)
        stop();
        if(code == KeyEvent.VK_ENTER)
        start();
    }

    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){
    }
}
