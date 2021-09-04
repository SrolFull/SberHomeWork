import java.util.*;

public class Task31Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        List<Car> carList = GSMParser.ParseRawGSMStringToList(input);
        Collections.sort(carList);
        System.out.printf("Общая стоимость расходов на ГСМ: %.2f %n%n", GSMUtility.CalcTotalFuelCost(carList));
        GSMUtility.PrintMaxAndMinConsumption(carList);
    }
}