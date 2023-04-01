class Rectangle extends Shape implements AreaFormula {
    private final double sideA;
    private final double sideB;

    public Rectangle(String name, double sideA, double sideB) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getAreaFormula() {
        return sideA * sideB;
    }
}
