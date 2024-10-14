import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int N = sc.nextInt();

    static long[] DP = new long[N+1];

    public static void main(String[] args) {

        DP[0] = 1;
        DP[1] = 1;

        for (int i = 2; i < N + 1; i++){

            DP[i] = (DP[i-2] * 2 + DP[i-1]) % 10007;

        }

        System.out.println(DP[N] % 10007);

    }

}