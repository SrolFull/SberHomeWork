import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GSMUtility {
    public static double CalcTotalFuelCost (List<Car> carList) {
        return carList.stream().
                mapToDouble(GSMUtility::CalcFuelCost)
                .sum();
    }

    private static HashMap<CarType, Double> CalcFuelCostByType (List<Car> carList) {
        HashMap<CarType, Double> res = new HashMap<>();
        carList.forEach(car -> res.put(car.getCarType(), res.getOrDefault(car.getCarType(), 0.0) + CalcFuelCost(car)));
        return res;
    }

    public static void PrintMaxAndMinConsumption (List<Car> carList) {
        HashMap<CarType, Double> map = CalcFuelCostByType(carList);
        double max = 0;
        double min = Double.MAX_VALUE;
        CarType carTypeMax = CarType.LIGHT;
        CarType carTypeMin = CarType.LIGHT;
        for (Map.Entry<CarType, Double> entry : map.entrySet()) {
            CarType k = entry.getKey();
            Double v = entry.getValue();
            if (v > max) {
                max = v;
                carTypeMax = k;
            }
            if (v < min) {
                min = v;
                carTypeMin = k;
            }
        }
        System.out.println("Тип авто имеющий наибольшую стоимость расходов: " + carTypeMax.codeCar);
        System.out.println("Тип авто имеющий наименьшую стоимость расходов: " + carTypeMin.codeCar);
    }

    private static double CalcFuelCost (Car car) {
        return car.getCarMileage() / 100 * car.getFuelConsumption().consumption * car.getFuelType().cost;
    }
}
