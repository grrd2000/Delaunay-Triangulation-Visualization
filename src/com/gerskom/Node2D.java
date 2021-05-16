package com.gerskom;

import java.awt.*;

public class Node2D {

    double x;
    double y;

    public Node2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("P[" + x + ", " + y + "]");
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(250,110,0));
        g2D.setStroke(new BasicStroke(9f));
        g2D.drawLine((int)x, (int)y, (int)x, (int)y);
    }
}
