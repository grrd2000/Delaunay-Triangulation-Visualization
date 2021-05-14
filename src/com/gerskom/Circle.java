package com.gerskom;

import java.awt.*;

public class Circle {
    Node2D o;
    double r;

    public Circle(Node2D o, double r) {
        this.o = o;
        this.r = r;
    }

    public Circle(Triangle t) {
        double M11 = (t.A.x * t.B.y) + (t.B.x * t.C.y) + (t.C.x * t.A.y) - (t.B.y * t.C.x) - (t.C.y * t.A.x) - (t.A.y * t.B.x);
        double M12 = (((t.A.x * t.A.x) + (t.A.y * t.A.y)) * t.B.y) + (((t.B.x * t.B.x) + (t.B.y * t.B.y)) * t.C.y) + (((t.C.x * t.C.x) + (t.C.y * t.C.y)) * t.A.y) - (((t.A.x * t.A.x) + (t.A.y * t.A.y)) * t.C.y) - (((t.B.x * t.B.x) + (t.B.y * t.B.y)) * t.A.y) - (((t.C.x * t.C.x) + (t.C.y * t.C.y)) * t.B.y);
        double M13 = (((t.A.x * t.A.x) + (t.A.y * t.A.y)) * t.B.x) + (((t.B.x * t.B.x) + (t.B.y * t.B.y)) * t.C.x) + (((t.C.x * t.C.x) + (t.C.y * t.C.y)) * t.A.x) - (((t.A.x * t.A.x) + (t.A.y * t.A.y)) * t.C.x) - (((t.B.x * t.B.x) + (t.B.y * t.B.y)) * t.A.x) - (((t.C.x * t.C.x) + (t.C.y * t.C.y)) * t.B.x);

        this.o = new Node2D((int)(0.5 * (M12/M11)), (int)(Math.abs(0.5 * (M13/M11))));
        this.r = Math.sqrt(Math.abs((t.A.x - o.x) * (t.A.x - o.x) + (t.A.y - o.y) * (t.A.y - o.y)));
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(1.5f));
        g2D.drawOval((int)(o.x - r), (int)(o.y - r), (int)r*2, (int)r*2);
    }
}
