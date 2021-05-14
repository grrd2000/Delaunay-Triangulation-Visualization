package com.gerskom;

import java.util.ArrayList;
import java.util.List;

public class DelaunayAlgorithm {
    List<Triangle> triangleList = new ArrayList<>();
    List<Node2D> pointsList = new ArrayList<>();

    public DelaunayAlgorithm(List<Node2D> nodes, Triangle superTriangle) {
        this.pointsList.add(superTriangle.A);
        this.pointsList.add(superTriangle.B);
        this.pointsList.add(superTriangle.C);
        this.pointsList.addAll(nodes);
        this.triangleList.add(superTriangle);
    }

    public List<Triangle> mesh() {



        return triangleList;
    }
}
