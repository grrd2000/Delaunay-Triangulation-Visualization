package com.gerskom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Triangle {

    Node2D A;
    Node2D B;
    Node2D C;

    LineSegment AB;
    LineSegment BC;
    LineSegment CA;

    List<Node2D> vertices = new ArrayList<>();
    List<LineSegment> edges = new ArrayList<>();

    Circle circle;

    public Triangle(Node2D a, Node2D b, Node2D c) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.AB = new LineSegment(a, b);
        this.BC = new LineSegment(b, c);
        this.CA = new LineSegment(c, a);
        this.circle = new Circle(this);
        assert false;
        this.edges.add(this.AB);
        this.edges.add(this.BC);
        this.edges.add(this.CA);
        this.vertices.add(this.A);
        this.vertices.add(this.B);
        this.vertices.add(this.C);
    }

    public Triangle(Node2D A, LineSegment BC) {
        this.A = A;
        this.B = BC.p1;
        this.C = BC.p2;
        this.AB = new LineSegment(this.A, this.B);
        this.BC = new LineSegment(this.B, this.C);
        this.CA = new LineSegment(this.C, this.A);
        this.circle = new Circle(this);
        assert false;
        this.edges.add(this.AB);
        this.edges.add(this.BC);
        this.edges.add(this.CA);
        this.vertices.add(this.A);
        this.vertices.add(this.B);
        this.vertices.add(this.C);
    }

    public Triangle(Node2D a, Node2D b, Node2D c, LineSegment AB, LineSegment BC, LineSegment CA) {
        A = a;
        B = b;
        C = c;
        this.AB = AB;
        this.BC = BC;
        this.CA = CA;
        assert false;
        this.edges.add(this.AB);
        this.edges.add(this.BC);
        this.edges.add(this.CA);
        this.vertices.add(this.A);
        this.vertices.add(this.B);
        this.vertices.add(this.C);
    }

    public boolean isInsideCircle(Node2D p) {
        return pow((this.circle.o.x - p.x),2) + (pow((this.circle.o.y - p.y),2)) < pow(this.circle.r,2);
    }

    public boolean isTheSame(Triangle t) {
        return  (this.A.equals(t.A) && this.B.equals(t.B) && this.C.equals(t.C)) ||
                (this.A.equals(t.B) && this.B.equals(t.C) && this.C.equals(t.A)) ||
                (this.A.equals(t.B) && this.B.equals(t.A) && this.C.equals(t.C)) ||
                (this.A.equals(t.C) && this.B.equals(t.B) && this.C.equals(t.A)) ||
                (this.A.equals(t.C) && this.B.equals(t.A) && this.C.equals(t.B)) ||
                (this.A.equals(t.A) && this.B.equals(t.C) && this.C.equals(t.B));
    }

    public void print() {
        this.A.print();
        this.B.print();
        this.C.print();
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
