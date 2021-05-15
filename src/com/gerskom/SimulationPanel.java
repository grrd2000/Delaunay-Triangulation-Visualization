package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {

    ImageData imageData;

    static List<Node2D> points = new ArrayList<>();
    static List<Node2D> uselessPoints = new ArrayList<>();
    static List<Triangle> triangles = new ArrayList<>();
    static List<Circle> circles = new ArrayList<>();

    public SimulationPanel(ImageData imageData) {
        super();
        this.imageData = imageData;
        this.setPreferredSize(new Dimension(imageData.width, imageData.height));
        points = imageData.keyPoints;
        addSuperTriangle();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        g2D.drawImage(imageData.image, 0, 0, null);

        for (Triangle triangle : triangles)
            triangle.paintComponent(g2D);

        for (Circle circle : circles)
            circle.paintComponent(g2D);

        for (Node2D node2D : points)
            node2D.paintComponent(g2D);

        for (Node2D node2D : uselessPoints)
            node2D.paintComponent(g2D);

        g2D.dispose();
    }

    public void addSuperTriangle() {
        Node2D A = new Node2D(this.imageData.width/2, 20);
        Node2D B = new Node2D(this.imageData.width - 75,  this.imageData.height - 75);
        Node2D C = new Node2D( 75, this.imageData.height - 75);
        Triangle superTriangle = new Triangle(A, B, C);
        triangles.add(superTriangle);
        uselessPoints.add(A);   uselessPoints.add(B);   uselessPoints.add(C);
        //circles.add(new Circle(superTriangle));
    }
}
