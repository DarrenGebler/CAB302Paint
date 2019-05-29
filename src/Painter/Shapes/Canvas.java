package Painter.Shapes;

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

public class Canvas extends JPanel implements Observer, MouseMotionListener, MouseListener {
    PaintModel paintModel;
    private DrawShapes drawShape = new DrawShapes();

    private View view;
    Shapes shapes;

    public Canvas(PaintModel paintModel, View view) {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300,300));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        this.paintModel = paintModel;
        this.paintModel.addObserver(this);

        this.view = view;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.paintModel.getColour());

        DrawStack drawStack = this.paintModel.getShapes();
        for (Shapes shapes : drawStack.getToDraw()) {
            shapes.accept(new ShapesDoPass(g2));
        }

        g2.setStroke(new BasicStroke(paintModel.getStrokeWidth()));
        this.paintModel.getPointer().draw(g2);
        g2.dispose();
    }

    public void update(Observable observable, Object obj) {
        this.repaint();
    }

    public void mouseMoved(MouseEvent e) {
        this.paintModel.changePointer(new Points(e.getX(), e.getY()), this.paintModel.getStrokeWidth());
    }

    public void mouseDragged(MouseEvent e) {
        if(this.shapes != null && e.getButton() != MouseEvent.BUTTON3) {
            this.paintModel.changePointer(new Points(e.getX(), e.getY()), this.paintModel.getStrokeWidth());
            this.shapes.calcForDraw(new Points(e.getX(), e.getY()));
            this.shapes.addToModel(this.paintModel);
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        Points start = new Points(e.getX(), e.getY());
        if(this.shapes == null) {
            this.shapes = drawShape.getShape(this.paintModel.getCurrent(), start, this.paintModel.getColour(), this.paintModel.getStroke(),
                    this.paintModel.getFilled(), this.paintModel.getStrokeWidth(), this.paintModel.getOutlined(), this.paintModel.getOutlineColour(), this);
        }
        else {
            if(e.getButton() == MouseEvent.BUTTON3) {
                this.shapes = null;
            }
            else {
                shapes.addPoint(start);
            }
        }
    }



}
