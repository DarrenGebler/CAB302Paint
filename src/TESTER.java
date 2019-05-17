import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author  Administrator
 * @created May 15, 2019
 */
public class TESTER extends JPanel implements MouseListener, MouseMotionListener
{
    static TESTER theTESTER;

    JPanel pnPanel0;
    JButton btLineBtn;
    JButton btPlotBtn;
    JButton btRectBtn;
    JButton btEllipseBtn;
    JButton btPolygonBtn;
    JComboBox cmbColourCmbo;
    JTextField tfHexText;

    JPanel jf;

    JPanel pnCanvasPanel;

    int clicks = 0;
    int x1 =0;
    int x2 = 0;
    int y1 = 0;
    int y2 = 0;
    Graphics g;

    private LinkedList<Point2D> click_locations = new LinkedList<>();

    private static final int R = 20;
    /**
     */
    public static void main( String args[] )
    {
//        JFrame jf = new JFrame();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch ( ClassNotFoundException e )
        {
        }
        catch ( InstantiationException e )
        {
        }
        catch ( IllegalAccessException e )
        {
        }
        catch ( UnsupportedLookAndFeelException e )
        {
        }
//        jf.add( new TESTER());
//        jf.setVisible(true);
        theTESTER = new TESTER();
    }


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
    /**
     */
    public TESTER()
    {
        JFrame jf = new JFrame();
        pnPanel0 = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout( gbPanel0 );

        btLineBtn = new JButton( "Line"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btLineBtn, gbcPanel0 );
        pnPanel0.add( btLineBtn );

        btPlotBtn = new JButton( "Plot"  );
        gbcPanel0.gridx = 4;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btPlotBtn, gbcPanel0 );
        pnPanel0.add( btPlotBtn );

        btRectBtn = new JButton( "Rectangle"  );
        gbcPanel0.gridx = 8;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btRectBtn, gbcPanel0 );
        pnPanel0.add( btRectBtn );

        btEllipseBtn = new JButton( "Ellipse"  );
        gbcPanel0.gridx = 12;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btEllipseBtn, gbcPanel0 );
        pnPanel0.add( btEllipseBtn );

        btPolygonBtn = new JButton( "Polygon"  );
        gbcPanel0.gridx = 16;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( btPolygonBtn, gbcPanel0 );
        pnPanel0.add( btPolygonBtn );

        String []dataColourCmbo = { "WHITE", "BLACK", "RED", "BLUE", "YELLOW" };
        cmbColourCmbo = new JComboBox( dataColourCmbo );
        gbcPanel0.gridx = 20;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( cmbColourCmbo, gbcPanel0 );
        pnPanel0.add( cmbColourCmbo );

        tfHexText = new JTextField( );
        gbcPanel0.gridx = 24;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( tfHexText, gbcPanel0 );
        pnPanel0.add( tfHexText );

        pnCanvasPanel = new JPanel();
        pnCanvasPanel.setBorder( BorderFactory.createTitledBorder( "Canvas" ) );
        GridBagLayout gbCanvasPanel = new GridBagLayout();
        GridBagConstraints gbcCanvasPanel = new GridBagConstraints();
        pnCanvasPanel.setLayout( gbCanvasPanel );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 1;
        gbcPanel0.gridwidth = 28;
        gbcPanel0.gridheight = 500;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( pnCanvasPanel, gbcPanel0 );
        pnCanvasPanel.setPreferredSize(new Dimension(640,480));
        pnCanvasPanel.add(new TESTER());
//        pnCanvasPanel.addMouseListener(new MouseLocator());
        pnPanel0.add( pnCanvasPanel );


        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        jf.setContentPane( pnPanel0 );
        jf.pack();
        addMouseListener(this);
        jf.setVisible( true );
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
}
