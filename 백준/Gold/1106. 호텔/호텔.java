import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[][] city;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int N = sc.nextInt();

        int[][] DP = new int[C+1][N+1];
        int answer = Integer.MAX_VALUE;

        city = new int[N][2];

        for  (int i = 0; i < N; i++) {
            int cost = sc.nextInt();
            int value = sc.nextInt();
            city[i][0] = cost;
            city[i][1] = value;
        }

        Arrays.sort(city,(a,b) -> {
            return Integer.compare(a[0] * b[1], a[1] * b[0]);
        });

        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= N; j++) {
                int cost = city[j-1][0];
                int value = city[j-1][1];

                if (i - value < 0){
                    DP[i][j] = cost;
                    continue;
                }

                DP[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= N; k++) {
                    DP[i][j] = Math.min(DP[i][j], DP[i-value][k] + cost);
                }
            }
        }

        for (int j = 1; j <= N; j++) {
            answer = Math.min(DP[C][j], answer);
        }

        System.out.println(answer);
    }



}
