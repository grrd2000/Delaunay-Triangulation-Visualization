package com.gerskom;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageData {

    BufferedImage image;
    public final int width;
    public final int height;
    List<Node2D> keyPoints = new ArrayList<>();

    ImageData(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
        this.width = image.getWidth();
        this.height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y ++) {
                Color tmpColor = new Color(image.getRGB(x, y), false);
                if(tmpColor.equals(Color.BLACK)) {
                    Node2D newPoint = new Node2D(x, y);
                    this.keyPoints.add(newPoint);
                }
            }
        }
        System.out.println("Number of nodes: " + keyPoints.size());
    }
}
