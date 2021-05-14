package com.gerskom;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {

    final int MAX_CAPACITY = 1;
    int level;
    List<Node2D> nodes;
    QuadTree northWest = null;
    QuadTree northEast = null;
    QuadTree southWest = null;
    QuadTree southEast = null;
    Boundary boundary;

    QuadTree(int level, Boundary boundary) {
        this.level = level;
        nodes = new ArrayList<>();
        this.boundary = boundary;
    }

    static void dfs(QuadTree tree) {

        if (tree == null)
            return;

        dfs(tree.northWest);
        dfs(tree.northEast);
        dfs(tree.southWest);
        dfs(tree.southEast);
    }

    void split() {
        int xOffset = this.boundary.getxMin() + (this.boundary.getxMax() - this.boundary.getxMin()) / 2;
        int yOffset = this.boundary.getyMin() + (this.boundary.getyMax() - this.boundary.getyMin()) / 2;

        northWest = new QuadTree(this.level + 1, new Boundary(this.boundary.getxMin(), this.boundary.getyMin(), xOffset, yOffset));
        northEast = new QuadTree(this.level + 1, new Boundary(xOffset, this.boundary.getyMin(), this.boundary.getxMax(), yOffset));
        southWest = new QuadTree(this.level + 1, new Boundary(this.boundary.getxMin(), yOffset, xOffset, this.boundary.getyMax()));
        southEast = new QuadTree(this.level + 1, new Boundary(xOffset, yOffset, this.boundary.getxMax(), this.boundary.getyMax()));
    }

    void insert(int x, int y, int value) {
        if (!this.boundary.inRange(x, y)) {
            return;
        }

        Node2D node = new Node2D(x, y, value);
        if (nodes.size() < MAX_CAPACITY) {
            nodes.add(node);
            return;
        }
        if (northWest == null) {
            split();
            SimulationPanel.addBoundary(boundary);
        }

        if (this.northWest.boundary.inRange(x, y))
            this.northWest.insert(x, y, value);
        else if (this.northEast.boundary.inRange(x, y))
            this.northEast.insert(x, y, value);
        else if (this.southWest.boundary.inRange(x, y))
            this.southWest.insert(x, y, value);
        else if (this.southEast.boundary.inRange(x, y))
            this.southEast.insert(x, y, value);
        else
            System.out.printf("ERROR : Unhandled partition %d %d", x, y);

    }
}
