package swingpaint;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import javax.swing.JComponent;
 

/**
 * 
* @author devarshi
* @since 2020-10-07
* 
* Java Swing Paint Application with 5 Colors: black, blue, green, red, magenta
* And a Clear Canvas Option
* 
*/


public class DrawBox extends JComponent {
 
    private Image image;  // Image in which we're going to draw
    private Graphics2D g2;    // Graphics2D object ==> used to draw on
    private int oldX, oldY, currentX, currentY;   //// Mouse coordinates
 
    public DrawBox() {
        setDoubleBuffered(false);
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // save coord x,y when mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
              // coord x,y when drag mouse
              currentX = e.getX();
              currentY = e.getY();

                if (g2 != null) {
                    // draw line if g2 context not null
                    g2.drawLine(oldX, oldY, currentX, currentY);  
                    repaint();    // refresh draw area to repaint

                    oldX = currentX;  // store current coords x,y as olds x,y
                    oldY = currentY;
                }
            }
        });
    }
 
    
    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }
 
    // now we create exposed methods
    public void clear() {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
 
    public void red() {
        // apply red color on g2 context
        g2.setPaint(Color.red);
    }
 
    public void black() {
        g2.setPaint(Color.black);
    }

    public void magenta() {
        g2.setPaint(Color.magenta);
    }

    public void green() {
        g2.setPaint(Color.green);
    }

    public void blue() {
        g2.setPaint(Color.blue);
    }
 
}
