import javax.swing.*;
import java.util.regex.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintForm extends JPanel{

    int x1 = 0;
    int x2 = 0;
    int y1 = 0;
    int y2 = 0;
    double width;
    double height;
    int clicks = 0;
//
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(Color.RED);
//        g.drawRect(5,5,10,10);
//    }
//
//    public void mouseEvents() {
//        JFrame jf = new JFrame();
//        PaintForm paint = new PaintForm();
//        jf.addMouseListener(new MouseLocator());
//
//        jf.setTitle("JAVA Paint");
//        jf.setSize(600,400);
//        jf.setVisible(true);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.add(paint);
//    }


    public static void main(String[] args){
        PaintForm p = new PaintForm();
//        p.mouseEvents();

    }

    public class MouseLocator implements MouseListener{
        public void mouseClicked(MouseEvent e) {
            clicks = clicks+1;
            if ((clicks % 2) != 0) {
                x1 = e.getXOnScreen();
                y1 = e.getYOnScreen();
            }
            else {
                x2 = e.getXOnScreen();
                y2 = e.getYOnScreen();
            }
            System.out.println(x1);
            System.out.println(x2);
            System.out.println(y1);
            System.out.println(y2);
        }

        public void mousePressed(MouseEvent e) {
//            System.out.println(e);
        }

        public void mouseReleased(MouseEvent e) {
//            System.out.println(e);
        }

        public void mouseEntered(MouseEvent e) {
//            System.out.println(e);
        }

        public void mouseExited(MouseEvent e) {
//            System.out.println(e);
        }
    }

}
