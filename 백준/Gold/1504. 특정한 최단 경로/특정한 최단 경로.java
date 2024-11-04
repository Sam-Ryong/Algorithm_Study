import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, E;
    static int[][] edges;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void floyd(int num){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(edges[i][num] != Integer.MAX_VALUE && edges[num][j] != Integer.MAX_VALUE)
                    edges[i][j] = Math.min(edges[i][j], edges[i][num]+edges[num][j]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        edges = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                edges[i][j] = Integer.MAX_VALUE;
                if (i == j)
                    edges[i][j] = 0;
            }
        }
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            edges[a][b] = c;
            edges[b][a] = c;
        }
        s = br.readLine().split(" ");
        int v1 = Integer.parseInt(s[0]);
        int v2 = Integer.parseInt(s[1]);

        for (int i = 1; i < N+1; i++) {
            floyd(i);
        }
        int result = Integer.MAX_VALUE;
        if (edges[1][v1] != Integer.MAX_VALUE && edges[v1][v2] != Integer.MAX_VALUE && edges[v2][N] != Integer.MAX_VALUE)
            result = edges[1][v1] + edges[v1][v2] + edges[v2][N];
        if(edges[1][v2] != Integer.MAX_VALUE && edges[v1][v2] != Integer.MAX_VALUE && edges[v1][N] != Integer.MAX_VALUE)
            result = Math.min(result,edges[1][v2] + edges[v2][v1] + edges[v1][N]);
        if (result == Integer.MAX_VALUE)
            result = -1;
        System.out.println(result);



    }
}