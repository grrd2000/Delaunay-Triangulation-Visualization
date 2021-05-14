package com.gerskom;

import java.awt.*;

public class Node2D {

    int x;
    int y;
    int value;

    public Node2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node2D(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public void print() {
        System.out.println("P[" + x + ", " + y + "]");
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(250,110,0));
        g2D.setStroke(new BasicStroke(5f));
        g2D.drawLine(x, y, x, y);
    }
}
