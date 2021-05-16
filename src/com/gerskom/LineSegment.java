package com.gerskom;

import java.awt.*;

public class LineSegment {
    Node2D p1;
    Node2D p2;

    public LineSegment(Node2D p1, Node2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void paintComponent (Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(3.5f));
        g2D.drawLine((int)p1.x,(int)p1.y,(int)p2.x,(int)p2.y);
    }

    public void print() {
        System.out.print("A:\t");
        p1.print();
        System.out.print("B:\t");
        p2.print();
    }
}