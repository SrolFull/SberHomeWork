public enum CarType {
    LIGHT(100),
    CARGO(200),
    HEAVY_PASSANGER(300),
    HEAVY_CRANE(400);

    int codeCar;

    CarType (int codeCar) {
        this.codeCar = codeCar;
    }

    public static CarType tryParse (String codeCar) {
        switch (codeCar) {
            case "100":
                return LIGHT;
            case "200":
                return CARGO;
            case "300":
                return HEAVY_PASSANGER;
            case "400":
                return HEAVY_CRANE;
            default:
                throw new IllegalArgumentException("Неверный тип авто");
        }
    }
}
