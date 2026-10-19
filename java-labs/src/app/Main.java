package app;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rect = new Rectangle(8, 14);
        Cylinder cylinder = new Cylinder(circle, 5);

        System.out.println(circle);
        System.out.println(rect);
        System.out.println(cylinder);
    }
}
