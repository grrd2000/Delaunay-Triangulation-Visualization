package com.gerskom;

public class Main {

    public static void main(String[] args) {

        int choice = 1;

        try {
            switch(choice) {
                case 1: new MyFrame(new ImageData("src/inputs/3_dots_input.png"));              //3 nodes
                case 2: new MyFrame(new ImageData("src/inputs/bullet_shape_input.png"));        //16 nodes
                case 3: new MyFrame(new ImageData("src/inputs/complex_shape_input.png"));       //62 nodes
                case 4: new MyFrame(new ImageData("src/inputs/deltoid_shape_input.png"));       //4 nodes
                case 5: new MyFrame(new ImageData("src/inputs/envelope_shape_input.png"));      //6 nodes
                case 6: new MyFrame(new ImageData("src/inputs/many_dots_input.png"));           //29 nodes
            }
        }
        catch (Exception exc) {
            System.out.println("Interrupted: " + exc.getMessage());
        }
    }
}
