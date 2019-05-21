
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.*;
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
    JComboBox cmbColourCmbo;
    JTextField tfHexText;

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

        String []dataColourCmbo = { "WHITE", "BLACK", "RED", "BLUE", "YELLOW" };
        cmbColourCmbo = new JComboBox( dataColourCmbo );
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 10;
        gbcPanel0.gridwidth = 4;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.EAST;
        gbPanel0.setConstraints( cmbColourCmbo, gbcPanel0 );
        pnPanel0.add( cmbColourCmbo );

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

        g.setColor(Color.red);

        int x,y;
        x = e.getX();
        y = e.getY();


        g.fillOval(x,y,5,5);
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {
        Graphics2D g = (Graphics2D) c.getGraphics();

        g.setColor(Color.red);

        int x,y;
        x = e.getX();
        y = e.getY();


        g.fillOval(x,y,5,5);
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
        if (x.contains("Line")) {
            System.out.println(x);
        }
        else if (x.contains("Plot")) {

        }
        else if (x.contains("Rectangle")) {

        }
        else if (x.contains("Ellipse")) {

        }
        else if (x.contains("Polygon")) {

        }

    }
}
