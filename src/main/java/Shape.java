interface IShape {
    void draw();
    void erase();
}
abstract class Circle implements IShape {
    public void draw() {
        System.out.println("Circle.draw()");
    }
}
abstract class Triangle implements IShape {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}

public class Shape {

    public static void main(String[] args) {
        IShape shape1 = new Circle() {
            @Override
            public void erase() {
                System.out.println("Circle.erase()");
            }
        };
        IShape shape2 = new Triangle() {
            @Override
            public void erase() {
                System.out.println("Triangle.erase()");
            }
        };
        testPoly(shape1);
        testPoly(shape2);
    }

    public static void testPoly(IShape shape) {
        shape.draw();
        shape.erase();
    }
}
