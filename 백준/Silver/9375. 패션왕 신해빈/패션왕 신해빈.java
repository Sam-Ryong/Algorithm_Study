import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int T = sc.nextInt();

    static Map<String,Integer> clothes = new HashMap<>();

    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < T; i++){
            int N = sc.nextInt();

            for (int j = 0; j < N; j++) {
                String name = sc.next();
                String category = sc.next();
                if (clothes.containsKey(category)) {
                    clothes.replace(category, clothes.get(category) + 1);
                } else {
                    clothes.put(category, 1);
                }
            }
            int result = 1;
            for (Integer value : clothes.values()) {
                result = result * (value + 1);
            }
            result--;
            output.append(result+"\n");
            clothes.clear();
        }
        System.out.println(output);
    }


}