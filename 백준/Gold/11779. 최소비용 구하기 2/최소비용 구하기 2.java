import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;

    static int[][] buses;
    static int[][] bridge;

    static ArrayList<Integer> root = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void floyd(){
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    if (buses[j][i] != Integer.MAX_VALUE && buses[i][k] != Integer.MAX_VALUE) {
                        if(buses[j][k] > buses[j][i] + buses[i][k]){
                            buses[j][k] = buses[j][i] + buses[i][k];
                            bridge[j][k] = i;
                        }

                    }
                }
            }
        }
    }

    public static void find(int i, int j){
        if (bridge[i][j] == 0 || bridge[i][j] == j || bridge[i][j] == i || i == 0 || j == 0) {
            root.add(j);
            return;
        }
        find(i,bridge[i][j]);
        find(bridge[i][j], j);
    }


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        buses = new int[N+1][N+1];
        bridge = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                buses[i][j] = Integer.MAX_VALUE;
                if (i == j)
                    buses[i][j] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            buses[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Math.min(buses[Integer.parseInt(s[0])][Integer.parseInt(s[1])],Integer.parseInt(s[2]));
        }
/*        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                System.out.print(buses[i][j] + " ");
            }
            System.out.println();
        }*/
        floyd();
/*        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                System.out.print(buses[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                System.out.print(bridge[i][j] + " ");
            }
            System.out.println();
        }*/
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        bw.write(buses[start][end] + "\n");
        root.add(start);
        find(start,end);
        bw.write(root.size()+"\n");
        for (Integer i : root) {
            bw.write(i + " ");
        }
        bw.write("\n");

        bw.flush();

    }
}