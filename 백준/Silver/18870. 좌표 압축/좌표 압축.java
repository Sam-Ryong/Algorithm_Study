import java.util.*;
import java.util.stream.IntStream;


public class Main{

    static Scanner sc = new Scanner(System.in);
    public static int N = sc.nextInt();
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static ArrayList<Integer> sorted = new ArrayList<Integer>();


    public static void main(String[] args) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> mappings = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++){
            int number = sc.nextInt();
            numbers.add(number);
            if (mappings.get(number) == null)
            {
                sorted.add(number);
                mappings.put(number,1);
            }
        }
        Collections.sort(sorted);
        for (int i = 0; i < sorted.size(); i++){
            mappings.replace(sorted.get(i), i);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++){
            output.append(mappings.get(numbers.get(i)));
            if (i != N - 1){
                output.append(" ");
            }
        }
        System.out.println(output);


    }
}