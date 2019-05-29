package Painter;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;
import Painter.Shapes.*;
import Painter.*;

/**
 * Actual Drawing to canvas functions
 * @author Darren Gebler, James Hassett
 */

public class Canvas extends JPanel implements Observer, MouseMotionListener, MouseListener {
    PaintModel paintModel;
    private DrawShapes drawShape = new DrawShapes();
    private View view;
    Shapes shapes;

    /**
     * Defines initial Canvas parameters
     * @param paintModel
     * @param view
     */

    public Canvas(PaintModel paintModel, View view) {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300,300));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.paintModel = paintModel;
        this.paintModel.addObserver(this);

        this.view = view;
    }

    /**
     * Drawing to canvas function
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(paintModel.getColour());

        DrawStack drawStack = paintModel.getShapes();
        for (Shapes shapes : drawStack.getToDraw()) {
            shapes.accept(new ShapesDoPass(g2));
        }

        g2.setStroke(new BasicStroke(paintModel.getStrokeWidth()));
        paintModel.getPointer().draw(g2);
        g2.dispose();
    }

    /**
     * Updates canvas
     * @param observable
     * @param obj
     */
    public void update(Observable observable, Object obj) {
        this.repaint();
    }

    /**
     * Mouse moving detection
     * Changes pointer location
     * @param e
     */
    public void mouseMoved(MouseEvent e) {
        paintModel.changePointer(new Points(e.getX(), e.getY()), paintModel.getStrokeWidth());
    }

    /**
     * Mouse dragged detection
     * Updates location of where shapes will been drawn
     * @param e
     */
    public void mouseDragged(MouseEvent e) {
        if(shapes != null && e.getButton() != MouseEvent.BUTTON3) {
            paintModel.changePointer(new Points(e.getX(), e.getY()), paintModel.getStrokeWidth());
            shapes.calcForDraw(new Points(e.getX(), e.getY()));
            shapes.addToModel(paintModel);
        }
    }

    /**
     * Mouse clicked detection
     * @param e
     */
    public void mouseClicked(MouseEvent e) {}

    /**
     * Mouse pressed detection
     * Sets initial parameters of shape
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        Points start = new Points(e.getX(), e.getY());
        if(shapes == null) {
            shapes = drawShape.getShape(paintModel.getCurrent(), start, paintModel.getColour(), paintModel.getStroke(),
                    paintModel.getFilled(), paintModel.getStrokeWidth(), paintModel.getOutlined(), paintModel.getOutlineColour(), this);
        }
        else {
            if(e.getButton() == MouseEvent.BUTTON3) {
                shapes = null;
            }
            else {
                shapes.addPoint(start);
            }
        }
    }

    /**
     * Mouse released detection
     * Sets final point where mouse is released
     * Sets finished state to true
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
        if(shapes != null && e.getButton() != MouseEvent.BUTTON3) {
            Points p = new Points(e.getX(), e.getY());
            shapes.calcForDraw(p);
            shapes.addToModel(paintModel);
            shapes.setFinished();
            if(shapes.getFinished() == true) {
                shapes = null;
            }
        }
    }

    /**
     * Mouse entered detection
     * @param e
     */
    public void mouseEntered(MouseEvent e){}

    /**
     * Mouse exited detection
     * @param e
     */
    public void mouseExited(MouseEvent e) {}



}
