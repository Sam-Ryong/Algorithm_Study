import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int result = 0;

    static char[][] map;

    static void walk(int i, int j){

        if (i < 0 || j < 0)
            return;
        if (i > N - 1 || j > M - 1)
            return;
        if (map[i][j] == 'X' || map[i][j] == 'V')
            return;
        if (map[i][j] == 'P')
        {
            result = result + 1;
        }
        map[i][j] = 'V';
        walk(i-1,j);
        walk(i+1,j);
        walk(i,j-1);
        walk(i,j+1);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new char[N][M];
        int[] pos = new int[2];

        for (int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I'){
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        walk(pos[0],pos[1]);

        if (result != 0)
            System.out.println(result);
        else
            System.out.println("TT");


    }


}