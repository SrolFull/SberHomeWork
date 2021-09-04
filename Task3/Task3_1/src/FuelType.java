public enum FuelType {
    LIGHT(46.10),
    CARGO(47.50),
    HEAVY(48.90);

    double cost;

    FuelType (double cost) {
        this.cost = cost;
    }
}
