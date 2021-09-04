import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GSMParser {
    public static List<Car> ParseRawGSMStringToList(String input){
        return Pattern.compile("C(\\d+)_(\\d+)-(\\d+)-?(\\d+)?")
                .matcher(input)
                .results()
                .map(res -> {
                    if (res.group(4) != null)
                        return new Car(CarType.tryParse(res.group(1)),Integer.parseInt(res.group(2)),Double.parseDouble(res.group(3)), Integer.parseInt(res.group(4)));
                    else
                        return new Car(CarType.tryParse(res.group(1)),Integer.parseInt(res.group(2)),Double.parseDouble(res.group(3)));
                })
                .collect(Collectors.toList());
    }
}
