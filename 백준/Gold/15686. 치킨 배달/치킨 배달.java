import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer[]> chicken = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int findNear(int i, int j, int[][] map){
        int result = Integer.MAX_VALUE;
        for (Integer[] points : chicken) {
            if (map[points[0]][points[1]] == 2){
                int distance = Math.abs(i-points[0]) + Math.abs(j-points[1]);
                if (distance < result)
                    result = distance;
            }
        }
        return result;
    }
    public static int countChickenDistance(int[][] map){
        int chickenDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    chickenDistance = chickenDistance + findNear(i,j,map);
            }
        }
        return chickenDistance;
    }

    public static void select(int num, int count, int[][] map){
        if (count == M){
            int result = countChickenDistance(map);
            if (min > result)
                min = result;
            return;
        }
        if (num == chicken.size()) {
            return;
        }

        int i = chicken.get(num)[0];
        int j = chicken.get(num)[1];

        select(num + 1, count, map);
        int[][] newMap = new int[N][N];
        for (int k = 0; k < N; k++) {
            newMap[k] = map[k].clone();
        }
        newMap[i][j] = 2;

        select(num + 1, count + 1, newMap);

    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int[][] map;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 2) {
                    map[i][j] = -1;
                    chicken.add(new Integer[]{i,j});
                }
            }
        }

        select(0,0,map);

        System.out.println(min);

    }
}