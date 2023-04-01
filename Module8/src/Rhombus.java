class Rhombus extends Shape implements AreaFormula {
    private final double diameter1;
    private final double diameter2;

    public Rhombus(String name, double diameter1, double diameter2) {
        super(name);
        this.diameter1 = diameter1;
        this.diameter2 = diameter2;
    }

    public double getAreaFormula() {
        return 0.5 * diameter1 * diameter2;
    }
}
