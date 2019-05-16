import javax.swing.*;
import java.awt.*;

public class Painting extends JPanel{
    int x1 = 0;
    int x2 = 0;
    int y1 = 0;
    int y2 = 0;

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.RED);

        g.drawRect(x1,x2,x2-x1,y2-y1);

    }

    public JPanel coordinate(int x1,  int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        JPanel jf = new JPanel();

        Painting p = new Painting();

        jf.setPreferredSize(new Dimension(640,480));
        jf.setVisible(true);
        jf.add(p);

        return jf;

    }


}
