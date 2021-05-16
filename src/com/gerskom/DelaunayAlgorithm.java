package com.gerskom;

import java.util.ArrayList;
import java.util.List;

public class DelaunayAlgorithm {
    List<Triangle> triangleList = new ArrayList<>();
    List<Node2D> pointsList = new ArrayList<>();

    public DelaunayAlgorithm(List<Node2D> nodes, Triangle superTriangle) {
        //this.pointsList.add(superTriangle.A);
        //this.pointsList.add(superTriangle.B);
        //this.pointsList.add(superTriangle.C);
        this.pointsList.addAll(nodes);
        this.triangleList.add(superTriangle);
    }

    public List<Triangle> mesh() {

        triangleList.add(new Triangle(pointsList.get(0), triangleList.get(0).A, triangleList.get(0).B));
        triangleList.add(new Triangle(pointsList.get(0), triangleList.get(0).B, triangleList.get(0).C));
        triangleList.add(new Triangle(pointsList.get(0), triangleList.get(0).C, triangleList.get(0).A));

        for(int i = 1; i < pointsList.size(); i++) {
            for(int j = 1; j < triangleList.size(); j++) {
                if(triangleList.get(j).isInsideCircle(pointsList.get(i))) {
                    triangleList.add(new Triangle(pointsList.get(i), triangleList.get(j).A, triangleList.get(j).B));
                    triangleList.add(new Triangle(pointsList.get(i), triangleList.get(j).B, triangleList.get(j).C));
                    triangleList.add(new Triangle(pointsList.get(i), triangleList.get(j).C, triangleList.get(j).A));
                    triangleList.remove(triangleList.get(j));
                    System.out.println(j);
                }
            }
        }
        System.out.println(triangleList.size());
        return triangleList;
    }
}
