import java.io.*;
import java.util.ArrayList;

public class Main {

    static int TC;
    static int[][] roads;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void floyd(int num, int N){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(roads[i][num] != Integer.MAX_VALUE && roads[num][j] != Integer.MAX_VALUE)
                    roads[i][j] = Math.min(roads[i][j], roads[i][num]+roads[num][j]);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        TC = Integer.parseInt(s[0]);

        for (int i = 0; i < TC; i++) {
            s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int W = Integer.parseInt(s[2]);
            roads = new int[N+1][N+1];
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    roads[j][k] = Integer.MAX_VALUE;
                    if (j == k)
                        roads[j][k] = 0;
                }
            }
            for (int j = 0; j < M; j++) {
                s = br.readLine().split(" ");
                int S = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                int T = Integer.parseInt(s[2]);
                roads[S][E] = Math.min(roads[S][E], T);
                roads[E][S] = Math.min(roads[E][S], T);
            }
            for (int j = 0; j < W; j++) {
                s = br.readLine().split(" ");
                int S = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                int T = Integer.parseInt(s[2]);
                roads[S][E] = Math.min(roads[S][E], T * (-1));
            }
            for (int j = 1; j < N+1; j++) {
                floyd(j,N);
            }
            boolean able = false;
            for (int j = 1; j < N+1; j++) {
                if (roads[j][j] < 0) {
                    able = true;
                    break;
                }
            }
            if (able)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();

    }
}