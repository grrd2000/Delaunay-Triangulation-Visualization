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
                if(triangle.isInsideCircle(point))
                    badTriangles.add(triangle);
            }
            List<LineSegment> polygon = new ArrayList<>();
            List<LineSegment> badEdges = new ArrayList<>();
            for(Triangle triangle : badTriangles)
                badEdges.addAll(triangle.edges);
            for(Triangle badTriangle : badTriangles) {
                for(LineSegment edge : badTriangle.edges) {
                    int counter = 0;
                    for(LineSegment badEdge : badEdges) {
                        if(edge.equals(badEdge)) {
                            counter++;
                            break;
                        }
                    }
                    if(counter == 1) polygon.add(edge);
                }
            }
            triangulation.removeAll(badTriangles);
            for(LineSegment edge : polygon) {
                    triangulation.add(new Triangle(point, edge));
            }
        }




       /* for(Node2D point : pointsList) {
            List<Triangle> badTriangles = new ArrayList<>();
            for(Triangle triangle : triangulation) {
                if(triangle.isInsideCircle(point)) {
                    badTriangles.add(triangle);
                }
            }

            List<LineSegment> edges = new ArrayList<>();

            for(Triangle triangle : badTriangles) {
                edges.addAll(triangle.edges);
            }

            for(int i = 0; i < badTriangles.size(); i++) {
                for(LineSegment badEdge : badTriangles.get(i).edges) {
                    for(int j = 0; j < edges.size(); j++) {
                        if(!badEdge.equals(edges.get(j)) && i != j) {
                            edges.remove(j);
                            j--;
                        }
                    }
                }
            }
            triangulation.removeAll(badTriangles);
            for(LineSegment edge : edges) {
                triangulation.add(new Triangle(point, edge));
            }
        }

        for(Node2D superVertex : superTriangle.vertices) {
            for(int i = 0; i < triangulation.size(); i++) {
                for(int j = 0; j < 3; j++) {
                    if (triangulation.get(i).vertices.get(j).equals(superVertex)) {
                        triangulation.remove(triangulation.get(i));
                        i--;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < triangulation.size(); i++) {
            for(int j = 0; j < triangulation.size(); j++) {
                if(triangulation.get(i).isTheSame(triangulation.get(j)) && i != j){
                    triangulation.remove(j);
                    j--;
                }
            }
        }

        for(int i = 0; i < triangulation.size(); i++) {
            System.out.println(i + ":");
            triangulation.get(i).print();
        }*/

        return triangulation;
    }
}
