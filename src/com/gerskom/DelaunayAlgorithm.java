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

        /*for (int i = 0; i < pointsList.size(); i++) {
            for (int j = 0; j < triangleList.size(); j++) {
                //SimulationPanel.circles.add(triangleList.get(j).circle);
                if (triangleList.get(j).isInsideCircle(pointsList.get(i))) {
                    triangleList.add(new Triangle(pointsList.get(i), triangleList.get(j).A, triangleList.get(j).B));
                    triangleList.add(new Triangle(pointsList.get(i), triangleList.get(j).B, triangleList.get(j).C));
                    triangleList.add(new Triangle(pointsList.get(i), triangleList.get(j).C, triangleList.get(j).A));
                    triangleList.remove(triangleList.get(j));

                    System.out.println(j);
                }
            }
        }*/

        List<Triangle> tmpTriangles = new ArrayList<>();

        for(Node2D node : pointsList) {
            boolean splitted = false;
            for(int j = 0; j < triangleList.size(); j++) {
                if(triangleList.get(j).isInsideCircle(node)){
                    tmpTriangles.add(new Triangle(node, triangleList.get(j).A, triangleList.get(j).B));
                    tmpTriangles.add(new Triangle(node, triangleList.get(j).B, triangleList.get(j).C));
                    tmpTriangles.add(new Triangle(node, triangleList.get(j).C, triangleList.get(j).A));
                    triangleList.remove(j);
                    j--;
                    splitted = true;
                    System.out.println(triangleList.size());
                }
            }



            if(splitted) {
                triangleList.add(tmpTriangles.get(tmpTriangles.size() - 1));
                triangleList.add(tmpTriangles.get(tmpTriangles.size() - 2));
                triangleList.add(tmpTriangles.get(tmpTriangles.size() - 3));
            }
        }


        /*for (int i = 0; i < pointsList.size(); i++) {
            for (int j = i+1; j < pointsList.size(); j++) {
                for (int k = j+1; k < pointsList.size(); k++) {
                    boolean isTriangle = true;
                    for (int a = 0; a < pointsList.size(); a++) {
                        if (a == i || a == j || a == k) continue;
                        if (new Triangle(pointsList.get(i), pointsList.get(j), pointsList.get(k)).isInsideCircle(pointsList.get(a))) {
                            isTriangle = false;
                            break;
                        }
                    }
                    if (isTriangle) {
                        triangleList.add(new Triangle(pointsList.get(i), pointsList.get(j), pointsList.get(k)));
                    }
                }
            }
        }*/

        System.out.println(triangleList.size());
        return triangleList;
    }
}
