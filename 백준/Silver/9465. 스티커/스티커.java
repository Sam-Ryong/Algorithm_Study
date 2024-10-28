import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int T;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        T = Integer.parseInt(s[0]);
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            int[][] DP = new int[2][N+1];

            for (int j = 0; j < 2; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    stickers[j][k] = Integer.parseInt(s[k]);
                }
            }
            DP[0][1] = stickers[0][0];
            DP[1][1] = stickers[1][0];

            for (int j = 2; j < N+1; j++) {
                DP[0][j] = Math.max(DP[1][j-1],Math.max(DP[0][j-2],DP[1][j-2])) + stickers[0][j-1];
                DP[1][j] = Math.max(DP[0][j-1],Math.max(DP[0][j-2],DP[1][j-2])) + stickers[1][j-1];
            }

            bw.write(String.valueOf(Math.max(DP[0][N],DP[1][N])) + "\n");
        }

        bw.flush();

    }
}