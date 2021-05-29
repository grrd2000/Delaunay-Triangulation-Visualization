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

    @Override
    public boolean equals(Object obj) {
        return this.x == ((Node2D) obj).x && this.y == ((Node2D) obj).y;
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(250,110,0));
        g2D.setStroke(new BasicStroke(9f));
        g2D.drawLine((int)x, (int)y, (int)x, (int)y);
    }
}
