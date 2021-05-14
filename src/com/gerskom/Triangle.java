package com.gerskom;

import java.awt.*;

public class Triangle {

    Node2D A;
    Node2D B;
    Node2D C;

    LineSegment AB;
    LineSegment BC;
    LineSegment CA;

    public Triangle(Node2D a, Node2D b, Node2D c) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.AB = new LineSegment(a, b);
        this.BC = new LineSegment(b, c);
        this.CA = new LineSegment(c, a);
    }

    public Triangle(Node2D a, Node2D b, Node2D c, LineSegment AB, LineSegment BC, LineSegment CA) {
        A = a;
        B = b;
        C = c;
        this.AB = AB;
        this.BC = BC;
        this.CA = CA;
    }

    public Triangle(Triangle triangle) {
        this.A = triangle.A;
        this.B = triangle.B;
        this.C = triangle.C;
        this.AB = triangle.AB;
        this.BC = triangle.BC;
        this.CA = triangle.CA;
    }

    public void paintComponent (Graphics g) {

        int[] xPoints = {A.x, B.x, C.x};
        int[] yPoints = {A.y, B.y, C.y};

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(2f));
        g2D.drawPolygon(xPoints, yPoints, 3);
        g2D.setPaint(new Color(180,180,180));
        g2D.fillPolygon(xPoints, yPoints, 3);
    }
}
