enum FuelConsumption {
    LIGHT(12.5),
    CARGO(12),
    HEAVY_PASSENGER(11.5),
    HEAVY_CRANE(20);

    double consumption;

    FuelConsumption (double consumption) {
        this.consumption = consumption;
    }

}
