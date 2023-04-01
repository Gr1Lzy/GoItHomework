class Circle extends Shape implements AreaFormula {
    private final double radius;
    private static final double PI = 3.14;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getAreaFormula() {
        return Math.pow(radius, 2) * PI;
    }
}
