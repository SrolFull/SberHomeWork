import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task1Main {
    public static void main(String[] args){
        String inputData = GetInputData();
        HashMap<Integer, List<Integer[]>> cars = ParseRawGSMtoMap(inputData);
        PrintTotalGSMCost(cars);
        PrintMaxMinGSMCostByCarType(cars);
        cars.entrySet().forEach(
                entry -> entry.setValue(SortCarsByMileageAndAdditionalParam(entry.getValue()))
        );
        PrintInfoAboutAllCar(cars);
    }

    private static String GetInputData(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    private static HashMap<Integer, List<Integer[]>> ParseRawGSMtoMap(String inputData){
        return Pattern.compile("C(\\d+)_(\\d+)-(\\d+)-?(\\d+)?")
                .matcher(inputData)
                .results()
                .collect(Collectors.toMap(Task1Main::KeyMapper,
                                          Task1Main::ValueMapper,
                                          Task1Main::MergeParams,
                                          HashMap::new));

    }

    private static List<Integer[]> MergeParams (List<Integer[]> p1, List<Integer[]> p2){
        p1.addAll(p2) ;
        return p1;
    }

    private static List<Integer[]> ValueMapper(MatchResult matchResult){
        Integer[] arr = new Integer[3];
        arr[0] = Integer.parseInt(matchResult.group(2));
        arr[1] = Integer.parseInt(matchResult.group(3));
        if (matchResult.group(4) != null)
            arr[2] = Integer.parseInt(matchResult.group(4));
        else
            arr[2] = 0;
        List<Integer[]> list = new ArrayList<>();
        list.add(arr);
        return list;
    }

    private static Integer KeyMapper(MatchResult matchResult){
        return Integer.parseInt(matchResult.group(1));
    }

    private static void PrintTotalGSMCost(HashMap<Integer, List<Integer[]>> cars){
        double res = cars.entrySet()
                .stream()
                .mapToDouble(Task1Main::CalcTotalFuelCostOnType)
                .sum();
        System.out.printf("%nОбщая стоимость расходов на GSM: %.2f %n" , res);
    }

    private static double CalcTotalFuelCostOnType(Map.Entry<Integer,List<Integer[]>> cars){
        return cars.getValue().stream().mapToDouble(car -> CalcFuelCost(cars.getKey(), car)).sum();
    }


    private static void PrintMaxMinGSMCostByCarType (HashMap<Integer, List<Integer[]>> cars) {
        double max=0;
        double min=Double.MAX_VALUE;
        int carTypeMax=0;
        int carTypeMin=0;
        for (Map.Entry<Integer,List<Integer[]>> entry: cars.entrySet()) {
            double cost = CalcTotalFuelCostOnType(entry);
            if (cost > max){
                max = cost;
                carTypeMax = entry.getKey();
            }
            if (cost < min){
                min = cost;
                carTypeMin = entry.getKey();
            }
        }
        System.out.printf("%nБольше всего расходов приходится на %d тип авто%n", carTypeMax);
        System.out.printf("Меньше всего расходов приходится на %d тип авто%n", carTypeMin);

    }

    private static double CalcFuelCost(Integer carType, Integer[] params){
        double fuelConsumption = 0;
        double fuelCost =0;
        double total=0;
        switch (carType) {
            case 100:
                fuelConsumption = FuelConsumption.LIGHT.consumption;
                fuelCost = FuelType.LIGHT.cost;
                break;
            case 200:
                fuelConsumption = FuelConsumption.CARGO.consumption;
                fuelCost = FuelType.HEAVY.cost;
                break;
            case 300:
                fuelConsumption = FuelConsumption.HEAVY_PASSENGER.consumption;
                fuelCost = FuelType.CARGO.cost;
                break;
            case 400:
                fuelConsumption = FuelConsumption.HEAVY_CRANE.consumption;
                fuelCost = FuelType.HEAVY.cost;
                break;
        }

            total += (double)params[1] / 100 * fuelCost * fuelConsumption;
        return total;
    }

    private static void PrintInfoAboutAllCar (HashMap<Integer, List<Integer[]>> cars) {
        for (Map.Entry<Integer, List<Integer[]>> entry : cars.entrySet()) {
            for(Integer[] car: entry.getValue()){
                System.out.printf("%nТип авто: %d | Номер авто: %d | Пробег: %d | Дополнительный параметр: %d |",
                                  entry.getKey(), car[0],car[1],car[2]);
            }
            System.out.println();
        }
    }

    private static List<Integer[]> SortCarsByMileageAndAdditionalParam(List<Integer[]> cars){
        Comparator<Integer[]> comparatorMileage = Comparator.comparing(arr -> arr[1]);
        Comparator<Integer[]> comparatorAdditionalParam = Comparator.comparing(arr -> arr[2]);
        cars.sort(comparatorMileage.thenComparing(comparatorAdditionalParam));
        return cars;
    }

}
