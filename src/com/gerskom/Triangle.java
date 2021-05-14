package com.gerskom;

import java.awt.*;

public class Triangle {

    Node2D A;
    Node2D B;
    Node2D C;

    public Triangle(Node2D a, Node2D b, Node2D c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public Triangle(Triangle triangle) {
        this.A = triangle.A;
        this.B = triangle.B;
        this.C = triangle.C;
    }

    public void paintComponent (Graphics g) {

        int[] xPoints = {A.x, B.x, C.x};
        int[] yPoints = {A.y, B.y, C.y};

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(1.5f));
        g2D.drawPolygon(xPoints, yPoints, 3);
        g2D.setPaint(new Color(52,52,52));
        g2D.fillPolygon(xPoints, yPoints, 3);
    }
}
