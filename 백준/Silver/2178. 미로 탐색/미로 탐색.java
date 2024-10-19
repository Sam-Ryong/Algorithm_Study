import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[][] maze;
    
    public static int bfs(int count, boolean[][] visited){
        ArrayList<Integer[]> nexts = new ArrayList<>();
        ArrayList<Integer[]> temp = new ArrayList<>();
        nexts.add(new Integer[]{1,0});
        nexts.add(new Integer[]{0,1});
        boolean end = false;
        while (true){
            count = count + 1;
            for (Integer[] next : nexts) {
                int i = next[0];
                int j = next[1];
                if (!(i < 0 || j < 0|| i > N - 1 || j > M - 1)){
                    if (i == N - 1 && j == M- 1)
                    {
                        count = count + 1;
                        end = true;
                        break;
                    }
                    if (!visited[i][j] && maze[i][j] == 1){
                        visited[i][j] = true;
                        temp.add(new Integer[]{i - 1, j});
                        temp.add(new Integer[]{i + 1, j});
                        temp.add(new Integer[]{i, j - 1});
                        temp.add(new Integer[]{i, j + 1});
                    }
                }

            }
            if (end)
                break;
            nexts.clear();
            nexts.addAll(temp);
            temp.clear();
        }

        return count;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        maze = new int[N][M];

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(bfs(0,visited));

    }
}