package com.gerskom;

import java.awt.*;

import static java.lang.Math.pow;

public class Triangle {

    Node2D A;
    Node2D B;
    Node2D C;

    LineSegment AB;
    LineSegment BC;
    LineSegment CA;

    Circle circle;

    public Triangle(Node2D a, Node2D b, Node2D c) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.AB = new LineSegment(a, b);
        this.BC = new LineSegment(b, c);
        this.CA = new LineSegment(c, a);
        this.circle = new Circle(this);
    }

    public Triangle(Node2D a, Node2D b, Node2D c, LineSegment AB, LineSegment BC, LineSegment CA) {
        A = a;
        B = b;
        C = c;
        this.AB = AB;
        this.BC = BC;
        this.CA = CA;
    }

    public boolean isInsideCircle(Node2D p) {
        return pow((this.circle.o.x - p.x),2) + (pow((this.circle.o.y - p.y),2)) < pow(this.circle.r,2) - 0.00000001;
    }

    public void paintComponent (Graphics g) {

        int[] xPoints = {(int)A.x, (int)B.x, (int)C.x};
        int[] yPoints = {(int)A.y, (int)B.y, (int)C.y};

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(2f));
        g2D.drawPolygon(xPoints, yPoints, 3);
        //g2D.setPaint(new Color(180,180,180));
        //g2D.fillPolygon(xPoints, yPoints, 3);
    }
}
