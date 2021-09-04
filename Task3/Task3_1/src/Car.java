public class Car implements Comparable<Car> {
    private CarType carType;
    private FuelConsumption fuelConsumption;
    private FuelType fuelType;
    private int additionalParameter;
    private int carNumber;
    private double carMileage;

    public Car(CarType carType, int carNumber, double carMileage ){
        setCarParameters(carType,carNumber,carMileage);
    }

    public Car(CarType carType, int carNumber, double carMileage, int additionalParameter){
        this.additionalParameter = additionalParameter;
        setCarParameters(carType,carNumber,carMileage);
    }

    private void setCarParameters(CarType carType, int carNumber, double carMileage){
        this.carType = carType;
        this.carNumber = carNumber;
        this.carMileage = carMileage;
        switch (carType){
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


    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public FuelConsumption getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(FuelConsumption fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getAdditionalParameter() {
        return additionalParameter;
    }

    public void setAdditionalParameter(int additionalParameter) {
        this.additionalParameter = additionalParameter;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    @Override
    public int compareTo(Car o) {
        return carType.compareTo(o.carType);
    }
}
