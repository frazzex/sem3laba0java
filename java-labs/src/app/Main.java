package app;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Circle circle = new Circle(10);
        Rectangle rect = new Rectangle(Double.POSITIVE_INFINITY, 14);
        Cylinder cylinder = new Cylinder(null, 5);
    }
}
