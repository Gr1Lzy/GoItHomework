public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle("Circle", 10);
        GetShapeName.printName(circle);
        System.out.println(circle.getAreaFormula());

        Quad quad = new Quad("Quad", 5);
        GetShapeName.printName(quad);
        System.out.println(quad.getAreaFormula());

        Rectangle rectangle = new Rectangle("Rectangle", 14, 10);
        GetShapeName.printName(rectangle);
        System.out.println(rectangle.getAreaFormula());

        Rhombus rhombus = new Rhombus("Rhombus", 6, 10);
        GetShapeName.printName(rhombus);
        System.out.println(rhombus.getAreaFormula());

        Trapezium trapezium = new Trapezium("Trapezium", 10, 12, 6);
        GetShapeName.printName(trapezium);
        System.out.println(trapezium.getAreaFormula());
    }
}
