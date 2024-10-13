import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int M = sc.nextInt();

    static Map<String,String> passwords = new HashMap<>();

    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++){
            passwords.put(sc.next(), sc.next());
        }

        for (int i = 0; i < M; i++){
            output.append(passwords.get(sc.next()));
            output.append("\n");
        }

        System.out.println(output);

    }
}