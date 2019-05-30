package Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author  Administrator
 * @created May 21, 2019
 * test change
 */
public class GUI extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener, ActionListener, ItemListener
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
    JCheckBox chbxFill;
    JLabel lblFill;

    String shape = "Line";
    String colorStr;

    int x1;
    int x2;
    int y1;
    int y2;
    int count = 0;

    boolean dragging;
    boolean fill = false;

    Color colourChoice = Color.BLACK;

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
        gbcPanel0.anchor = GridBagConstraints.WEST;
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
        gbcPanel0.anchor = GridBagConstraints.WEST;
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
        gbcPanel0.anchor = GridBagConstraints.WEST;
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
        gbcPanel0.anchor = GridBagConstraints.WEST;
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
        gbcPanel0.anchor = GridBagConstraints.WEST;
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
        gbcPanel0.anchor = GridBagConstraints.WEST;
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
        gbcPanel0.anchor = GridBagConstraints.WEST;
        gbPanel0.setConstraints( tfHexText, gbcPanel0 );
        pnPanel0.add( tfHexText );

        chbxFill = new JCheckBox();
        gbcPanel0.gridx=2;
        gbcPanel0.gridy = 14;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.WEST;
        gbPanel0.setConstraints( chbxFill, gbcPanel0 );
        chbxFill.addItemListener(this);
        pnPanel0.add(chbxFill);

        lblFill = new JLabel("Fill");
        gbcPanel0.gridx=0;
        gbcPanel0.gridy = 14;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 2;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.WEST;
        gbPanel0.setConstraints( lblFill, gbcPanel0 );
        pnPanel0.add(lblFill);

        MenuBar menu = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        file.add(new MenuItem("New", new MenuShortcut(1)));
        file.add(new MenuItem("Open", new MenuShortcut(2)));
        file.add(new MenuItem("Save", new MenuShortcut(3)));
        file.add(new MenuItem("Export As", new MenuShortcut(4)));
        edit.add(new MenuItem("Undo", new MenuShortcut(5)));
        menu.add(file);
        menu.add(edit);
        menu.add(help);
        this.setMenuBar(menu);

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

        pnPanel0.add(c);

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
        g.setColor(colourChoice);

        switch (shape) {
            case "Line":
                g.drawLine(x1,y1,x2,y2);
                break;
            case "Rectangle":
                if (fill == false) {
                    if (x1 == x2) {
                        g.drawRect(x1, y1, 2, 2);
                    } else if (x1 < x2 && y1 < y2) {
                        g.drawRect(x1, y1, (x2 - x1), (y2 - y1));
                    } else if (x1 > x2 && y1 > y2) {
                        g.drawRect(x2, y2, (x1 - x2), (y1 - y2));
                    } else if (x1 > x2 && y1 < y2) {
                        g.drawRect(x2, y1, (x1 - x2), (y2 - y1));
                    } else {
                        g.drawRect(x1, y2, (x2 - x1), (y1 - y2));
                    }
                }
                else {
                    if (x1 == x2) {
                        g.fillRect(x1, y1, 2, 2);
                    } else if (x1 < x2 && y1 < y2) {
                        g.fillRect(x1, y1, (x2 - x1), (y2 - y1));
                    } else if (x1 > x2 && y1 > y2) {
                        g.fillRect(x2, y2, (x1 - x2), (y1 - y2));
                    } else if (x1 > x2 && y1 < y2) {
                        g.fillRect(x2, y1, (x1 - x2), (y2 - y1));
                    } else {
                        g.fillRect(x1, y2, (x2 - x1), (y1 - y2));
                    }
                }
                break;
            case "Ellipse":
                if (!fill) {
                    if (x1 == x2) {
                        g.draw(new Ellipse2D.Double(x1, y1, 2, 2));
                    } else if (x1 < x2 && y1 < y2) {
                        g.draw(new Ellipse2D.Double(x1, y1, (x2 - x1), (y2 - y1)));
                    } else if (x1 > x2 && y1 > y2) {
                        g.draw(new Ellipse2D.Double(x2, y2, (x1 - x2), (y1 - y2)));
                    } else if (x1 > x2 && y1 < y2) {
                        g.draw(new Ellipse2D.Double(x2, y1, (x1 - x2), (y2 - y1)));
                    } else {
                        g.draw(new Ellipse2D.Double(x1, y2, (x2 - x1), (y1 - y2)));
                    }
                }
                else if (fill){
                    if (x1 == x2) {
                        g.fill(new Ellipse2D.Double(x1, y1, 2, 2));
                    } else if (x1 < x2 && y1 < y2) {
                        g.fill(new Ellipse2D.Double(x1, y1, (x2 - x1), (y2 - y1)));
                    } else if (x1 > x2 && y1 > y2) {
                        g.fill(new Ellipse2D.Double(x2, y2, (x1 - x2), (y1 - y2)));
                    } else if (x1 > x2 && y1 < y2) {
                        g.fill(new Ellipse2D.Double(x2, y1, (x1 - x2), (y2 - y1)));
                    } else {
                        g.fill(new Ellipse2D.Double(x1, y2, (x2 - x1), (y1 - y2)));
                    }
                }

                break;
            case "Plot":
                g.fillOval(x2,y2,2,2);
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
        System.out.println(e);

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
            colourChoice = c.please;
            System.out.println(colourChoice);
//            colourChoice = c.returnCol();
        }

    }

    public void retCol (Color c) {
        colourChoice = c;
    }

    public void itemStateChanged(ItemEvent e) {
        int x = e.getStateChange();
        System.out.println(colourChoice);
        if (x == 1) {
            fill = true;
        }
        else {
            fill = false;
        }
    }
}
