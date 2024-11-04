import java.io.*;
import java.util.ArrayList;

public class Main {

    static int R, C;
    static char[][] board;

    static int max = Integer.MIN_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int i, int j, boolean[] visit, int count){
        if (i < 0 || j < 0 || i > R-1 || j > C-1)
            return;
        if (visit[board[i][j]-65])
            return;
        if (count > max)
            max = count;
        visit[board[i][j]-65] = true;
        dfs(i-1,j,visit.clone(),count+1);
        dfs(i+1,j,visit.clone(),count+1);
        dfs(i,j-1,visit.clone(),count+1);
        dfs(i,j+1,visit.clone(),count+1);
    }


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        board = new char[R][C];
        // A : 65, Z : 90

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = charArray[j];
            }
        }
        dfs(0,0,new boolean[26], 1);

        System.out.println(max);


    }
}