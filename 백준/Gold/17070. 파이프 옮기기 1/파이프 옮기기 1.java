import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N;

    static int[][] house;

    static int count = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Pipe{
        int r1;
        int c1;
        int r2;
        int c2;

        int status = 0; // 가로 0 세로 1 대각선 2

        public void setPos(int r1, int c1, int r2, int c2){
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }

    public static void dfs(Pipe pipe){
        if (pipe.r2 == N && pipe.c2 == N) {
            count++;
            return;
        }
        if (pipe.status == 0){
            if (pipe.c2 + 1 <= N && house[pipe.r2][pipe.c2 + 1] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r1,pipe.c1+1,pipe.r2,pipe.c2+1);
                newPipe.status = 0;
                dfs(newPipe);
            }
            if (pipe.c2 + 1 <= N && pipe.r2 + 1 <= N && house[pipe.r2][pipe.c2 + 1] == 0 && house[pipe.r2 + 1][pipe.c2] == 0 && house[pipe.r2 + 1][pipe.c2 + 1] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r2, pipe.c2,pipe.r2+1,pipe.c2+1);
                newPipe.status = 2;
                dfs(newPipe);
            }

        }
        else if (pipe.status == 1){
            if (pipe.r2 + 1 <= N && house[pipe.r2+1][pipe.c2] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r1+1,pipe.c1,pipe.r2+1,pipe.c2);
                newPipe.status = 1;
                dfs(newPipe);
            }
            if (pipe.c2 + 1 <= N && pipe.r2 + 1 <= N && house[pipe.r2][pipe.c2 + 1] == 0 && house[pipe.r2 + 1][pipe.c2] == 0 && house[pipe.r2 + 1][pipe.c2 + 1] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r2, pipe.c2,pipe.r2+1,pipe.c2+1);
                newPipe.status = 2;
                dfs(newPipe);
            }
        }
        else if (pipe.status == 2){
            if (pipe.c2 + 1 <= N && house[pipe.r2][pipe.c2 + 1] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r2,pipe.c2, pipe.r2,pipe.c2+1);
                newPipe.status = 0;
                dfs(newPipe);
            }
            if (pipe.r2 + 1 <= N && house[pipe.r2+1][pipe.c2] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r2,pipe.c2,pipe.r2+1,pipe.c2);
                newPipe.status = 1;
                dfs(newPipe);
            }
            if (pipe.c2 + 1 <= N && pipe.r2 + 1 <= N && house[pipe.r2][pipe.c2 + 1] == 0 && house[pipe.r2 + 1][pipe.c2] == 0 && house[pipe.r2 + 1][pipe.c2 + 1] == 0){
                Pipe newPipe = new Pipe();
                newPipe.setPos(pipe.r2, pipe.c2,pipe.r2+1,pipe.c2+1);
                newPipe.status = 2;
                dfs(newPipe);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        house = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j < N+1; j++) {
                house[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        Pipe pipe = new Pipe();
        pipe.setPos(1,1,1,2);
        dfs(pipe);

        System.out.println(count);

    }
}