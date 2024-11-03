import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static long[][] table;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void floyd(int num){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (table[i][num] != Integer.MAX_VALUE && table[num][j] != Integer.MAX_VALUE)
                    table[i][j] = Math.min(table[i][j], table[i][num] + table[num][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] s;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        table = new long[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                table[i][j] = Integer.MAX_VALUE;
                if (i == j)
                    table[i][j] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            if( Integer.parseInt(s[0]) != Integer.parseInt(s[1]))
                table[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Math.min(table[Integer.parseInt(s[0])][Integer.parseInt(s[1])],Integer.parseInt(s[2]));
        }
        for (int i = 1; i < N+1; i++) {
            floyd(i);
        }
        s = br.readLine().split(" ");
        System.out.println(table[Integer.parseInt(s[0])][Integer.parseInt(s[1])]);
    }
}