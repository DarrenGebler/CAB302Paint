import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.LinkedList;

public class paintingTrial extends JPanel implements MouseListener, MouseMotionListener{

    private LinkedList<Point2D> click_locations = new LinkedList<>();

    private static final int R = 20;

    public paintingTrial() {
        setBackground(Color.WHITE);

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        click_locations.addLast(e.getPoint());
        repaint();
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    boolean disk_selected = false;
    int selected_disk_index = 0;
    Point2D last_mouse_location;

    public void mousePressed(MouseEvent e) {
        Iterator<Point2D> ite = click_locations.descendingIterator();
        int index = click_locations.size() - 1;
        while (ite.hasNext()) {
            if (e.getPoint().distance(ite.next())<R) {
                disk_selected =true;
                selected_disk_index = index;
                last_mouse_location = e.getPoint();
                break;
            }
            index = index-1;

        }
    }
    public void mouseReleased(MouseEvent e) {
        disk_selected = false;
    }
    public void mouseDragged(MouseEvent e) {
        if(disk_selected) {
            Point2D current_center = click_locations.get(selected_disk_index);
            Point2D new_center = new Point2D.Double(current_center.getX()+e.getX()-last_mouse_location.getX(),
                    current_center.getY()+e.getY()-last_mouse_location.getY());
            click_locations.set(selected_disk_index, new_center);
            last_mouse_location=e.getPoint();
            repaint();

        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setStroke(new BasicStroke(2));

        double hue =0;
        for (Point2D pt: click_locations) {
            Ellipse2D e = new Ellipse2D.Double(pt.getX()- R, pt.getY() - R, 2*R, 2*R);
            g2d.setColor(Color.getHSBColor((float) hue, 1f, 1f));
            g2d.fill(e);
            g2d.setColor(Color.BLACK);
            g2d.draw(e);

            hue = hue+(Math.sqrt(5)-1)/2;
            hue = hue - Math.floor(hue);
        }
    }

    public static void main(String[] args) {
        // Construct a new window:
        JFrame frame = new JFrame("InteractionDemo");
        // Dimensions of the window in pixels:
        frame.setSize(640, 480);
        // Quit the program when the window is closed:
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // The window will contain only our panel:
        frame.add(new paintingTrial());
        // Make the window visible:
        frame.setVisible(true);
    }


}
