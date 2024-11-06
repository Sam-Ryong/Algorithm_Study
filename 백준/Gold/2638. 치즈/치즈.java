import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;

    static int[][] cheese;
    static boolean[][] visit;

    static ArrayList<Integer[]> C = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean checkAir(int i, int j){
        int count = 0;
        if (cheese[i-1][j] == 0)
            count++;
        if (cheese[i+1][j] == 0)
            count++;
        if (cheese[i][j-1] == 0)
            count++;
        if (cheese[i][j+1] == 0)
            count++;

        return count >= 2;

    }

    public static void airProcess(int i, int j){
        if (i == -1 || i == N || j == -1 || j == M || cheese[i][j] == 1 || visit[i][j])
            return;
        visit[i][j] = true;
        cheese[i][j] = 0;
        airProcess(i-1,j);
        airProcess(i+1,j);
        airProcess(i,j-1);
        airProcess(i,j+1);
    }

    public static int melt(){
        ArrayList<Integer[]> temp = new ArrayList<>();
        ArrayList<Integer[]> temp2 = new ArrayList<>();
        int time = 0;
        while (C.size() > 0){
            visit = new boolean[N][M];
            airProcess(0,0);
            time++;
            for (Integer[] c : C) {
                if (!checkAir(c[0],c[1]))
                    temp.add(c);
                else
                    temp2.add(c);
            }
            for (Integer[] c : temp2) {
                cheese[c[0]][c[1]] = 0;
            }
            C.clear();
            C.addAll(temp);
            temp.clear();
            temp2.clear();
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        cheese = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(s[j]);
                if (cheese[i][j] == 1)
                    C.add(new Integer[]{i,j});
                if (cheese[i][j] == 0)
                    cheese[i][j] = -1;
            }
        }

        System.out.println(melt());




    }
}