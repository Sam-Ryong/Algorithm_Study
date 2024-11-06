import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N;

    static int[][] ocean;

    static BabyShark babyShark = new BabyShark();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class BabyShark{

        int[] position = new int[2];
        int size = 2;
        int exp = 0;

        public void move(int i, int j){
            position[0] = i;
            position[1] = j;
            exp++;
            if (exp == size) {
                size++;
                exp = 0;
            }
        }

    }

    public static int bfs(int i, int j){
        ArrayList<Integer[]> next = new ArrayList<>();
        ArrayList<Integer[]> temp = new ArrayList<>();
        boolean[][] visit = new boolean[N][N];
        next.add(new Integer[]{i,j});
        visit[i][j] = true;
        int time = 0;
        int x = N;
        int y = N;
        boolean isFound = false;
        while (next.size() > 0){
            for (Integer[] pos : next) {
                if (ocean[pos[0]][pos[1]] > 0 && ocean[pos[0]][pos[1]] < babyShark.size) {
                    isFound = true;
                    if (pos[0] < y) {
                        x = pos[1];
                        y = pos[0];
                    } else if (pos[0] == y && pos[1] < x) {
                        x = pos[1];
                    }
                }
                else if (ocean[pos[0]][pos[1]] == 0 || ocean[pos[0]][pos[1]] == babyShark.size ||(pos[0] == babyShark.position[0] && pos[1] == babyShark.position[1])){
                //else if (ocean[pos[0]][pos[1]] == 0 || ocean[pos[0]][pos[1]] == babyShark.size ||ocean[pos[0]][pos[1]] == 9){
                    if (pos[0] > 0 && !visit[pos[0]-1][pos[1]]) {
                        visit[pos[0]-1][pos[1]] = true;
                        temp.add(new Integer[]{pos[0] - 1, pos[1]});
                    }
                    if (pos[0] < N-1 && !visit[pos[0]+1][pos[1]]) {
                        visit[pos[0]+1][pos[1]] = true;
                        temp.add(new Integer[]{pos[0] + 1, pos[1]});
                    }
                    if (pos[1] > 0 && !visit[pos[0]][pos[1]-1]) {
                        visit[pos[0]][pos[1]-1] = true;
                        temp.add(new Integer[]{pos[0], pos[1] - 1});
                    }
                    if (pos[1] < N-1 && !visit[pos[0]][pos[1]+1]) {
                        visit[pos[0]][pos[1]+1] = true;
                        temp.add(new Integer[]{pos[0], pos[1] + 1});
                    }
                }
            }
            if (isFound) {
                ocean[babyShark.position[0]][babyShark.position[1]] = 0;
                babyShark.move(y,x);
                ocean[y][x] = -1;
                break;
            }
            next.clear();
            next.addAll(temp);
            temp.clear();
            time++;
        }
        return isFound ? time : -1;
    }
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        ocean = new int[N][N];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ocean[i][j] = Integer.parseInt(s[j]);
                if (ocean[i][j] == 9){
                    babyShark.position[0] = i;
                    babyShark.position[1] = j;
                    ocean[i][j] = -1;
                }
            }
        }
        int time = 0;
        while (true){
            int overhead = bfs(babyShark.position[0],babyShark.position[1]);
            if (overhead < 0)
                break;
            time += overhead;
        }
        System.out.println(time);


    }
}