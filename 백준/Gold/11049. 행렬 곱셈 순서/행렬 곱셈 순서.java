import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[][] matrix;

    static int[][] DP;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        matrix = new int[N][2];
        DP = new int[N][N];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(s[0]);
            matrix[i][1] = Integer.parseInt(s[1]);
        }
        for (int i = 0; i < N-1; i++) {
            DP[i][i+1] = matrix[i][0]*matrix[i+1][0]*matrix[i+1][1];
        }
        /*
        (ABC)
        A(BC)

        (ABCDE)
        A(BCDE)
        AB(CDE)
        ABC(DE)
         */
        for (int diagonal = 2; diagonal < N; diagonal++) {
            for (int i =  N - diagonal - 1; i >= 0; i--) {
                int j = i + diagonal;
                DP[i][j] = DP[i][j-1] + matrix[i][0] * matrix[j][0] * matrix[j][1];
                for (int k = 1; k < j-i; k++) {
                    DP[i][j] = Math.min(DP[i][j], DP[i][i+k-1] + DP[i+k][j] + matrix[i+k][0] * matrix[i][0] * matrix[j][1]);
                }
            }
        }
        
        System.out.println(DP[0][N-1]);


    }
}