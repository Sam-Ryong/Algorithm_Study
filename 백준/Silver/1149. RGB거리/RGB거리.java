import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int N, M;

    static int[][] costs;

    static int[][] DP;

    static int min = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        costs = new int[N][3];
        DP = new int[N][3];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(s[j]);
            }
        }

        DP[0] = costs[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k){
                        if (DP[i-1][k] < min){
                            min = DP[i-1][k];
                        }
                    }
                }
                DP[i][j] = min + costs[i][j];
            }
        }

        int result = DP[N-1][0];

        if (result > DP[N-1][1])
            result = DP[N-1][1];

        if (result > DP[N-1][2])
            result = DP[N-1][2];

        System.out.println(result);


    }
}