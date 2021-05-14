package com.gerskom;

import java.awt.*;

public class Boundary {

    int xMin, yMin, xMax, yMax;

    public Boundary(int xMin, int yMin, int xMax, int yMax) {
        super();

        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean inRange(int x, int y) {
        return (x >= this.getxMin() && x <= this.getxMax()
                && y >= this.getyMin() && y <= this.getyMax());
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(1.5f));
        g2D.drawLine(xMin, yMax, xMax, yMax);
        g2D.drawLine(xMax, yMax, xMax, yMin);
        g2D.drawLine(xMax, yMin, xMin, yMin);
        g2D.drawLine(xMin, yMin, xMin, yMax);
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public void print() {
        System.out.println("Boundary{" +
                "xMin=" + xMin +
                ", yMin=" + yMin +
                ", xMax=" + xMax +
                ", yMax=" + yMax +
                '}');
    }
}
