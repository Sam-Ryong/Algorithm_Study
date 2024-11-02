import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M, X;
    static int[][] roads;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void floyd(int num){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (roads[i][num] != Integer.MAX_VALUE && roads[num][j] != Integer.MAX_VALUE)
                    roads[i][j] = Math.min(roads[i][j], roads[i][num] + roads[num][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        roads = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                roads[i][j] = Integer.MAX_VALUE;
                if (i == j)
                    roads[i][j] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            roads[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[2]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N+1; i++) {
            floyd(i);
        }

        for (int i = 1; i < N+1; i++) {
            if (roads[i][X] + roads[X][i] > max)
                max = roads[i][X] + roads[X][i];
        }
        System.out.println(max);

    }
}