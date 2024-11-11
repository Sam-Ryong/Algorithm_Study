import com.sun.security.auth.NTSid;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;
    static int[] bytes;
    static int[] times;

    static int[][] DP;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        bytes = new int[N+1];
        times = new int[N+1];
        int sumOfTime = 0;
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            bytes[i+1] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            times[i+1] = Integer.parseInt(s[i]);
            sumOfTime += times[i + 1];
        }
        DP = new int[N+1][sumOfTime+1];
        int result = sumOfTime;
        for (int i = 1; i < N+1; i++) {
            boolean isFound = false;
            for (int j = 0; j < sumOfTime + 1; j++) {
                if (times[i] <= j) {
                    DP[i][j] = Math.max(DP[i - 1][j - times[i]] + bytes[i], DP[i - 1][j]);
                } else {
                    DP[i][j] = DP[i - 1][j];
                }
                if (DP[i][j] >= M) {
                    if (j < result)
                        result = j;
                }
            }
        }
        bw.write(result + "\n");
        bw.flush();


    }

}