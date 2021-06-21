package com.gerskom;

import java.util.ArrayList;
import java.util.List;

public class DelaunayAlgorithm {
    List<Triangle> triangulation = new ArrayList<>();
    List<Node2D> pointsList = new ArrayList<>();
    Triangle superTriangle;

    public DelaunayAlgorithm(List<Node2D> nodes, Triangle superTriangle) {
        //this.pointsList.add(superTriangle.A);
        //this.pointsList.add(superTriangle.B);
        //this.pointsList.add(superTriangle.C);
        this.pointsList.addAll(nodes);
        this.superTriangle = superTriangle;
        this.triangulation.add(this.superTriangle);
    }

    public List<Triangle> mesh() {

        for(Node2D point : pointsList) {
            List<Triangle> badTriangles = new ArrayList<>();
            for(Triangle triangle : triangulation) {
                if(triangle.isInsideCircle(point) && !point.equals(triangle.A) && !point.equals(triangle.B) && !point.equals(triangle.C))
                    badTriangles.add(triangle);
            }
            List<LineSegment> polygon = new ArrayList<>();
            for(Triangle triangle : badTriangles) {
                if (isEdgeUsed(badTriangles, triangle, triangle.AB) && !polygon.contains(triangle.AB))
                    polygon.add(triangle.AB);
                if (isEdgeUsed(badTriangles, triangle, triangle.BC) && !polygon.contains(triangle.BC))
                    polygon.add(triangle.BC);
                if (isEdgeUsed(badTriangles, triangle, triangle.CA) && !polygon.contains(triangle.CA))
                    polygon.add(triangle.CA);
            }

            this.triangulation.removeAll(badTriangles);

            for(LineSegment edge : polygon)
                this.triangulation.add(new Triangle(point, edge));
        }

        this.triangulation.removeIf(triangle ->
                pointIsPartOfSuperTriangle(this.superTriangle, triangle.A) ||
                pointIsPartOfSuperTriangle(this.superTriangle, triangle.B) ||
                pointIsPartOfSuperTriangle(this.superTriangle, triangle.C));

        return this.triangulation;
    }

    public List<LineSegment> voronoiDiagram(List<Triangle> triangulation) {
        List <LineSegment> voronoiDiagram = new ArrayList<>();
        for(Triangle triangle : triangulation) {
            for(Triangle triangle1 : triangulation) {
                if (triangle.equals(triangle1)) continue;
                if(triangle.AB.equals(triangle1.AB) || triangle.AB.equals(triangle1.BC) || triangle.AB.equals(triangle1.CA) ||
                        triangle.BC.equals(triangle1.CA) || triangle.BC.equals(triangle1.BC) || triangle.CA.equals(triangle1.CA))
                    voronoiDiagram.add(new LineSegment(triangle.circle.o, triangle1.circle.o));
            }
        }
        System.out.println("Voronoi diagram: " + voronoiDiagram.size());
        return voronoiDiagram;
    }

    private boolean isEdgeUsed(List<Triangle> toDelete, Triangle source, LineSegment e) {
        for(Triangle t : toDelete) {
            if(t.equals(source))
                continue;
            if(t.AB.equals(e) || t.BC.equals(e) || t.CA.equals(e))
                return false;
        }
        return true;
    }

    private boolean pointIsPartOfSuperTriangle(Triangle superTriangle, Node2D p) {
        return superTriangle.A.equals(p) || superTriangle.B.equals(p) || superTriangle.C.equals(p);
    }
}
