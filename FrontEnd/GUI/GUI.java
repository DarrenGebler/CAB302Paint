import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 * @author  Administrator
 * @created May 21, 2019
 */
public class GUI extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener, ActionListener
{
    static GUI gui;

    Canvas c;

    JPanel pnPanel0;
    JButton btLineBtn;
    JButton btPlotBtn;
    JButton btRectBtn;
    JButton btEllipseBtn;
    JButton btPolygonBtn;
    JButton btColourBtn;
    JTextField tfHexText;

    String shape = "Line";
    String colorStr;

    int x1;
    int x2;
    int y1;
    int y2;
    int count = 0;

    boolean dragging;

    JPanel pnCanvasPanel;
    /**
     */
    public static void main( String args[] )
    {
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
        gui = new GUI();
    }

    /**
     */
    public GUI()
    {
        super( "JAVA Paint" );

        pnPanel0 = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout( gbPanel0 );

        btLineBtn = new JButton( "Line"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( btLineBtn, gbcPanel0 );
        btLineBtn.addActionListener(this);
        pnPanel0.add( btLineBtn );

        btPlotBtn = new JButton( "Plot"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 2;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( btPlotBtn, gbcPanel0 );
        btPlotBtn.addActionListener(this::actionPerformed);
        pnPanel0.add( btPlotBtn );

        btRectBtn = new JButton( "Rectangle"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( btRectBtn, gbcPanel0 );
        btRectBtn.addActionListener(this::actionPerformed);
        pnPanel0.add( btRectBtn );

        btEllipseBtn = new JButton( "Ellipse"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 6;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( btEllipseBtn, gbcPanel0 );
        btEllipseBtn.addActionListener(this);
        pnPanel0.add( btEllipseBtn );

        btPolygonBtn = new JButton( "Polygon"  );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 8;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( btPolygonBtn, gbcPanel0 );
        btPolygonBtn.addActionListener(this);
        pnPanel0.add( btPolygonBtn );

        btColourBtn = new JButton("Colours");
        gbcPanel0.gridx=0;
        gbcPanel0.gridy = 10;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 2;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( btColourBtn, gbcPanel0 );
        btColourBtn.addActionListener(this);
        pnPanel0.add( btColourBtn );

        tfHexText = new JTextField( );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 12;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( tfHexText, gbcPanel0 );
        pnPanel0.add( tfHexText );

//        pnCanvasPanel = new JPanel();
//        pnCanvasPanel.setBorder( BorderFactory.createTitledBorder( "Canvas" ) );
//        GridBagLayout gbCanvasPanel = new GridBagLayout();
//        GridBagConstraints gbcCanvasPanel = new GridBagConstraints();
//        pnCanvasPanel.setLayout( gbCanvasPanel );
//        gbcPanel0.gridx = 0;
//        gbcPanel0.gridy = 1;
//        gbcPanel0.gridwidth = 28;
//        gbcPanel0.gridheight = 19;
//        gbcPanel0.fill = GridBagConstraints.BOTH;
//        gbcPanel0.weightx = 1;
//        gbcPanel0.weighty = 0;
//        gbcPanel0.anchor = GridBagConstraints.NORTH;
//        gbPanel0.setConstraints( pnCanvasPanel, gbcPanel0 );
//        pnCanvasPanel.setPreferredSize(new Dimension(640,480) );

        c = new Canvas(){
            public void paint(Graphics2D g){
            }
        };
        GridBagLayout gbCanvas = new GridBagLayout();
        GridBagConstraints gbcCanvas = new GridBagConstraints();
        c.setBackground(Color.white);
        c.addMouseListener(this);
        c.addMouseMotionListener(this);
        c.addMouseWheelListener(this);

        c.setPreferredSize(new Dimension(640,480));

        pnPanel0.add( c );

        setDefaultCloseOperation( EXIT_ON_CLOSE );

        setContentPane( pnPanel0 );
        pack();
        setVisible( true );
    }
    public void mouseClicked(MouseEvent e) {
        Graphics2D g = (Graphics2D) c.getGraphics();

        System.out.println(colorStr);

        g.setColor(Color.getColor(colorStr));
    }
    public void mousePressed(MouseEvent e) {
        dragging = true;
        x1 = e.getX();
        y1 = e.getY();
        System.out.println("X1 = " + x1 + "Y1 = " +y1);
    }
    public void mouseReleased(MouseEvent e) {
        Graphics2D g = (Graphics2D) c.getGraphics();
        dragging = false;
        x2 = e.getX();
        y2 = e.getY();
        System.out.println("X2 = " + x2 + "Y2 = " +y2);

        switch (shape) {
            case "Line":
                g.drawLine(x1,y1,x2,y2);
                break;
            case "Rectangle":
                if (x1 == x2) {
                    g.drawRect(x1,y1,2,2);
                }
                else if (x1<x2 && y1<y2) {
                    g.drawRect(x1,y1,(x2-x1),(y2-y1));
                }
                else if (x1>x2 && y1>y2){
                    g.drawRect(x2,y2,(x1-x2),(y1-y2));
                }
                else if (x1>x2 && y1<y2) {
                    g.drawRect(x2,y1,(x1-x2),(y2-y1));
                }
                else {
                    g.drawRect(x1,y2,(x2-x1),(y1-y2));
                }
                break;
            case "Ellipse":
                g.draw(new Ellipse2D.Double(x1,y1,5,5));
                break;
            case "Plot":
                g.fillOval(x1,y1,2,2);
                break;
//          case "Polygon"
//              g.drawPolygon();
            }
        x2 = 0;
        y2 = 0;
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {
        Graphics2D g = (Graphics2D) c.getGraphics();

        g.setColor(Color.getColor(colorStr));
        dragging = true;

//        System.out.println(e);

    }
    public void mouseMoved(MouseEvent e) {

    }

    //potential solution for zooming
    public void mouseWheelMoved(MouseWheelEvent e) {
        Graphics2D g = (Graphics2D) c.getGraphics();
        int rot = e.getWheelRotation();

        if(rot == -1) {
            g.scale(4,4);
        }
        else {
            g.scale(0.5,0.5);
        }
    }
    //Button Pressed function used for changing brush type
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e);

        String x = e.paramString();
        String y = e.getActionCommand();
        if (x.contains("Line")) {
            shape = "Line";
        }
        else if (x.contains("Plot")) {
            shape = "Plot";
        }
        else if (x.contains("Rectangle")) {
            shape = "Rectangle";
        }
        else if (x.contains("Ellipse")) {
            shape = "Ellipse";
        }
        else if (x.contains("Polygon")) {
            shape = "Polygon";
        }

        if (x.contains("Colours")) {
            ColourPicker c = new ColourPicker();
            c.createAndShowGUI();


        }

    }
}
