import java.util.List;

class Task35Main {

    public static void main(String[] args) {
        String[] inp = List.of("Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1").toArray(new String[0]);
        System.out.print(findWinner(inp));
    }

    private static String findWinner(String[] arr){
        int max = 0;
        String name = "No winners";

        for (String str : arr) {
            String[] inp = str.split(" ");
            int score = Integer.parseInt(inp[1]);
            if (score > max) {
                name = inp[0];
                max = score;
            }
        }
        return name;
    }
}
