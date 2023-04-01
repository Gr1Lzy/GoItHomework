class Quad extends Shape implements AreaFormula {
    private final double side;

    public Quad(String name, double side) {
        super(name);
        this.side = side;
    }

    public double getAreaFormula() {
        return side * side;
    }
}
