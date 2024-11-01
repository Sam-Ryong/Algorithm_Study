import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;
    static Node[] nodes;
    static int[][] results;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        ArrayList<Integer[]> bus = new ArrayList<>();
    }

    public static void floyd(int num){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (results[i][num] != Integer.MAX_VALUE && results[num][j] != Integer.MAX_VALUE)
                    results[i][j] = Math.min(results[i][j], results[i][num] + results[num][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(br.readLine());
        nodes = new Node[101];
        results = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == j)
                    results[i][j] = 0;
                else {
                    results[i][j] = Integer.MAX_VALUE;
                }
            }

        }

        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            results[a][b] = Math.min(results[a][b],c);
        }

        for (int i = 1; i < N+1; i++) {
            floyd(i);
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (results[i][j] == Integer.MAX_VALUE || results[i][j] < 0)
                    results[i][j] = 0;
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }
}