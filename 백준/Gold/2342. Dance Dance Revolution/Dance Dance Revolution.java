import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;

public class Main {

    static int[] instructions;
    static int[][][] DP;

    static int[][] overhead = new int[5][5];


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = s.length;
        instructions = new int[N];
        for (int i = 0; i < N; i++) {
            instructions[i] = Integer.parseInt(s[i]);
        }
        DP = new int[N][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || j == 0){
                    overhead[i][j] = 2;
                }
                else if (Math.abs(i-j) == 1 || Math.abs(i-j) == 3){
                    overhead[i][j] = 3;
                }
                else if (Math.abs(i-j) == 2){
                    overhead[i][j] = 4;
                }
                if (i == j){
                    overhead[i][j] = 1;
                }
            }
        }

        DP[1][instructions[0]][0] = 2;
        DP[1][0][instructions[0]] = 2;

        for (int i = 1; i < N-1; i++) {

            int now = instructions[i];

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (DP[i][j][k] > 0){
                        if (DP[i+1][j][now] == 0)
                            DP[i + 1][j][now] = DP[i][j][k] + overhead[k][now];
                        else
                            DP[i + 1][j][now] = Math.min(DP[i][j][k] + overhead[k][now], DP[i + 1][j][now]);
                        if (DP[i + 1][now][k] == 0)
                            DP[i + 1][now][k] = DP[i][j][k] + overhead[j][now];
                        else
                            DP[i + 1][now][k] = Math.min(DP[i][j][k] + overhead[j][now],  DP[i + 1][now][k]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (DP[N-1][i][j] != 0)
                    result = Math.min(result, DP[N - 1][i][j]);
            }
        }
        System.out.println(result);

    }

}
