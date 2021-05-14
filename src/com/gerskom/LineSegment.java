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
        g2D.setStroke(new BasicStroke(2f));
        g2D.drawLine(p1.x,p1.y,p2.x,p2.y);
    }

    public void print() {
        System.out.print("A:\t");
        p1.print();
        System.out.print("B:\t");
        p2.print();
    }
}