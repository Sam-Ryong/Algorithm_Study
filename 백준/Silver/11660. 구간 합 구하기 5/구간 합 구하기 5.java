import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int N, M;

    static int[][] matrix;

    static long max = Long.MIN_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        matrix = new int[N+1][N+1];

        for (int i = 1; i < N + 1; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1] + Integer.parseInt(s[j-1]);
            }
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            long result = matrix[x2][y2] - matrix[x2][y1 - 1] - matrix[x1 - 1][y2] + matrix[x1 - 1][y1 - 1];
            bw.write(String.valueOf(result) + "\n");

        }
        bw.flush();

    }
}