import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static int N, M, R;

    static int[] items;

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
        R = Integer.parseInt(s[2]);
        items = new int[N+1];
        roads = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                roads[i][j] = Integer.MAX_VALUE;
                if (i == j)
                    roads[i][j] = 0;
            }
        }
        s = br.readLine().split(" ");
        for (int i = 1; i < N+1; i++) {
            items[i] = Integer.parseInt(s[i-1]);
        }
        for (int i = 0; i < R; i++) {
            s = br.readLine().split(" ");
            roads[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[2]);
            roads[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = Integer.parseInt(s[2]);
        }
        int result = 0;
        for (int i = 1; i < N+1; i++) {

            floyd(i);

        }

        for (int i = 1; i < N+1; i++) {
            int able = 0;
            for (int j = 1; j < N+1; j++) {
                if (roads[i][j] <= M)
                    able = able + items[j];
            }
            if (result < able)
                result = able;
        }

        System.out.println(result);


    }
}