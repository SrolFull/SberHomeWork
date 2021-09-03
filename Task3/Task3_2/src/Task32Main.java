import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Task32Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        sc.close();

        TreeMap<Character, Integer> dictionary = new TreeMap<>();

        IntStream.range(0, input.length()).
                mapToObj(input::charAt).
                forEach(ch -> dictionary.put(ch, dictionary.getOrDefault(ch, 0) + 1));

        System.out.print(dictionary.toString());
    }
}
