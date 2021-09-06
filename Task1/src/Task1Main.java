import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Task1Main {
    private static double[] CarsCostsByType = new double[4];
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            List<ArrayList<String>> inputData = ParseGSMtoArrayList(input);
            PrintFuelCost(inputData);
            PrintMaxAndMinType();
            ArrayList<ArrayList<ArrayList<String>>> data = SortCarsByType(inputData);
            for (int i=0;i<data.size();i++) {
                 data.set(i, SortByMileageOrAdditional(data.get(i)));
            }
            PrintSortedInfoAboutGSM(data);
    }
    private static void PrintSortedInfoAboutGSM(ArrayList<ArrayList<ArrayList<String>>> data){
        data.forEach(arrayLists -> {
            arrayLists.forEach(car -> {
                System.out.printf("Тип авто: %s | Номер авто: %s | Пробег: %s", car.get(0),car.get(1),car.get(2));
                if (car.size() == 4) System.out.printf("| Дополнительный параметр : %s", car.get(3));
                System.out.printf("%n");
            });
            System.out.printf("%n");
        });
    }

    /**
     * Sorts the list by additional information otherwise by mileage
     * @param inp ArrayList of car of the same type
     * @return Sorted inp ArrayList
     * */
    private static ArrayList<ArrayList<String>> SortByMileageOrAdditional(ArrayList<ArrayList<String>> inp){
        return (ArrayList<ArrayList<String>>) inp.stream().
                sorted(Comparator.comparing(a -> {
                    if (a.size() == 4) return Integer.parseInt(a.get(3));
                    return Integer.parseInt(a.get(2));
                }))
                .collect(Collectors.toList());
    }

    private static ArrayList<ArrayList<ArrayList<String>>> SortCarsByType(List<ArrayList<String>> data){
        ArrayList<ArrayList<String>> type1 = new ArrayList<>(10);
        ArrayList<ArrayList<String>> type2 = new ArrayList<>(10);
        ArrayList<ArrayList<String>> type3 = new ArrayList<>(10);
        ArrayList<ArrayList<String>> type4 = new ArrayList<>(10);
        for (ArrayList<String> datum : data) {
            int carType = Integer.parseInt(datum.get(0));
            switch (carType) {
                case 100:
                    type1.add(datum);
                    break;
                case 200:
                    type2.add(datum);
                    break;
                case 300:
                    type3.add(datum);
                    break;
                case 400:
                    type4.add(datum);
                    break;
            }
        }
        ArrayList<ArrayList<ArrayList<String>>> res = new ArrayList<>(4);
        res.add(type1);
        res.add(type2);
        res.add(type3);
        res.add(type4);
        return res;
    }

    /***
     * Print info about fuel cost by type
     */
    private static void PrintMaxAndMinType(){
     double min=Double.MAX_VALUE,max=CarsCostsByType[0];
     int minType=100, maxType=100;
        for(int i=0;i<4;i++){
         if (CarsCostsByType[i] < min) {
             min = CarsCostsByType[i];
             minType = (i+1)*100;
         }
         if (CarsCostsByType[i] > max) {
             max = CarsCostsByType[i];
            maxType = (i+1)*100;
         }
     }
        System.out.println("Тип авто имеющий наибольшую стоимость расходов: " + maxType);
        System.out.printf("Тип авто имеющий наименьшую стоимость расходов: %d %n%n", minType);
    }

    /***
     * Printing GSM total fuel cost
     * @param data List of GSM strings " C(Code_Car)_state number-mileage-(additional parameter) "
     */
    private static void PrintFuelCost(List<ArrayList<String>> data){
        final double FUEL_COST_LIGHT = 46.10;
        final double FUEL_COST_MIDDLE = 47.50;
        final double FUEL_COST_HEAVY = 48.90;
        final double FUEL_CONSUMPTION_LIGHT = 12.5 ;
        final double FUEL_CONSUMPTION_MIDDLE = 12 ;
        final double FUEL_CONSUMPTION_HEAVY_PASSANGER = 11.5;
        final double FUEL_CONSUMPTION_HEAVY_TYPE2 = 20 ;

        float TotalCost = 0;
        double cost;
        for(ArrayList<String> list : data){
            int carType = Integer.parseInt(list.get(0));
            float carMileage = Float.parseFloat(list.get(2));
            float fuelMultiplier = carMileage / 100;
            switch (carType){
                case 100:
                    cost = fuelMultiplier * FUEL_CONSUMPTION_LIGHT * FUEL_COST_LIGHT ;
                    TotalCost += cost;
                    CarsCostsByType[0] +=cost;
                    break;
                case 200:
                    cost = fuelMultiplier * FUEL_CONSUMPTION_MIDDLE * FUEL_COST_HEAVY ;
                    TotalCost += cost;
                    CarsCostsByType[1] +=cost;
                    break;
                case 300:
                    cost = fuelMultiplier * FUEL_CONSUMPTION_HEAVY_PASSANGER * FUEL_COST_MIDDLE ;
                    TotalCost += cost;
                    CarsCostsByType[2] +=cost;
                    break;
                case 400:
                    cost = fuelMultiplier * FUEL_CONSUMPTION_HEAVY_TYPE2 * FUEL_COST_HEAVY ;
                    TotalCost += cost;
                    CarsCostsByType[3] +=cost;
                    break;
            }
        }
        System.out.format("Общая стоимость расходов на ГСМ: %.2f %n%n" ,TotalCost);
    }

    /**
     * Parsing GSM string to array of parameters
     * @param str gsm string
     * @return array of strings params - C(Code_Car)_state number-mileage-(additional parameter)
     * */
    private static ArrayList<String> GetParamsFromGSMString(String str){
        Pattern p = Pattern.compile("C(\\d+)_(\\d+)-(\\d+)-?(\\d+)?");
        Matcher m = p.matcher(str);
        if (!m.find()) throw new  IllegalArgumentException();
        ArrayList<String> data = new ArrayList<>(4);
        data.add(m.group(1));
        data.add(m.group(2));
        data.add(m.group(3));
        if (m.group(4) != null) data.add(m.group(4));
        return data;
    }

    /***
     * Parsing GSM`s data to List of strings
     * @param input CLI string data
     * @return Array list of of arrays integers parameters
    ***/
    private static List<ArrayList<String>> ParseGSMtoArrayList(String input){
        return Pattern.compile("\"(.*?)+\"")
                .matcher(input)
                .results()
                .map(x-> GetParamsFromGSMString(x.group().replace("\"", "")))
                .collect(Collectors.toList());
    }
}
