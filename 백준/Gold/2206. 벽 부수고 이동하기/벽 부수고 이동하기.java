import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int N,M;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int bfs(){

        ArrayList<Integer[]> next = new ArrayList<>();
        ArrayList<Integer[]> temp = new ArrayList<>();
        boolean[][][] visit = new boolean[N][M][2];


        next.add(new Integer[]{0,0,0});
        int count = 1;
        boolean arrive = false;
        
        while (next.size() > 0){
            for (Integer[] i : next) {
                if (i[0] == N - 1 && i[1] == M - 1) {
                    arrive = true;
                    break;
                }
                if (!visit[i[0]][i[1]][i[2]]) {
                    visit[i[0]][i[1]][i[2]] = true;
                    if (map[i[0]][i[1]] == 1 && i[2] == 0) {
                        if (i[0] > 0)
                            temp.add(new Integer[]{i[0] - 1, i[1], 1});
                        if (i[0] < N - 1)
                            temp.add(new Integer[]{i[0] + 1, i[1], 1});
                        if (i[1] > 0)
                            temp.add(new Integer[]{i[0], i[1] - 1, 1});
                        if (i[1] < M - 1)
                            temp.add(new Integer[]{i[0], i[1] + 1, 1});
                    } else if (map[i[0]][i[1]] == 0) {
                        if (i[0] > 0)
                            temp.add(new Integer[]{i[0] - 1, i[1], i[2]});
                        if (i[0] < N - 1)
                            temp.add(new Integer[]{i[0] + 1, i[1], i[2]});
                        if (i[1] > 0)
                            temp.add(new Integer[]{i[0], i[1] - 1, i[2]});
                        if (i[1] < M - 1)
                            temp.add(new Integer[]{i[0], i[1] + 1, i[2]});
                    }
                }

            }
            if (arrive)
                break;
            count++;
            next.clear();
            next.addAll(temp);
            temp.clear();
        }
        if (arrive)
            return count;
        else
            return -1;
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(bfs());


    }
}