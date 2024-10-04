import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];
        DP[0] = 1;
        DP[1] = 1;

        for (int i = 2; i < N + 1; i++){
            DP[i] = DP[i-1] + DP[i-2];
            DP[i] = DP[i] % 10007;
        }

        System.out.println(DP[N]);
    }
}