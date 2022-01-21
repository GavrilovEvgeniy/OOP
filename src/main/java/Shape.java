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

abstract class Square implements IShape {
    public void draw() {
        System.out.println("Square.draw()");
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
        IShape shape3 = new Square() {
            @Override
            public void erase() {
                System.out.println("Square.erase()");
            }
        };
        testPoly(shape1);
        testPoly(shape2);
        testPoly(shape3);
    }

    public static void testPoly(IShape shape) {
        shape.draw();
        shape.erase();
    }
}
