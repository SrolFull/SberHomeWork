public class Car {
    private CarType carType;
    private FuelConsumption fuelConsumption;
    private FuelType fuelType;
    private int additionalParameter;
    private int carNumber;
    private double carMileage;

    public Car (CarType carType, int carNumber, double carMileage) {
        setCarParameters(carType, carNumber, carMileage);
    }

    public int getAdditionalParameter () {
        return additionalParameter;
    }

    public Car (CarType carType, int carNumber, double carMileage, int additionalParameter) {
        this.additionalParameter = additionalParameter;
        setCarParameters(carType, carNumber, carMileage);
    }

    private void setCarParameters (CarType carType, int carNumber, double carMileage) {
        this.carType = carType;
        this.carNumber = carNumber;
        this.carMileage = carMileage;
        switch (carType) {
            case LIGHT:
                fuelConsumption = FuelConsumption.LIGHT;
                fuelType = FuelType.LIGHT;
                break;
            case CARGO:
                fuelConsumption = FuelConsumption.CARGO;
                fuelType = FuelType.HEAVY;
                break;
            case HEAVY_CRANE:
                fuelConsumption = FuelConsumption.HEAVY_CRANE;
                fuelType = FuelType.CARGO;
                break;
            case HEAVY_PASSANGER:
                fuelConsumption = FuelConsumption.HEAVY_PASSENGER;
                fuelType = FuelType.HEAVY;
                break;
        }
    }


    public CarType getCarType () {
        return carType;
    }

    public FuelConsumption getFuelConsumption () {
        return fuelConsumption;
    }

    public FuelType getFuelType () {
        return fuelType;
    }

    public double getCarMileage () {
        return carMileage;
    }

    @Override
    public String toString () {
        return "Тип авто: " + carType.codeCar
                + "Номер авто:  " + carNumber
                + "Пробег: " + carMileage
                + "Допольнительный пармераметр" + additionalParameter;
    }
}
