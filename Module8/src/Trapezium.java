class Trapezium extends Shape implements AreaFormula {
    private final double sideA;
    private final double sideB;
    private final double height;

    public Trapezium(String name, double sideA, double sideB, double height) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
    }

    private double middleLine() {
        return (sideA + sideB) / 2;
    }

    public double getAreaFormula() {
        return middleLine() * height;
    }
}