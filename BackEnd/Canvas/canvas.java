import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class canvas extends JFrame implements MouseListener, MouseMotionListener {

    Canvas c;

    canvas() {
        super("Canvas");

        c = new Canvas() {
            public void paint(Graphics g) {
            }
        };
        c.setBackground(Color.WHITE);

        c.addMouseListener(this);
        c.addMouseMotionListener(this);

        add(c);
        setSize(640,480);
        show();

    }

    public void mouseClicked(MouseEvent e) {
        Graphics g = c.getGraphics();

        g.setColor(Color.red);

        int x,y;
        x = e.getX();
        y = e.getY();

        g.fillOval(x,y,5,5);

    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = c.getGraphics();

        g.setColor(Color.red);

        int x,y;
        x = e.getX();
        y = e.getY();

        g.fillOval(x,y,5,5);
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e)  {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }

    public static void main(String[] args) {
        canvas c = new canvas();
    }


}
