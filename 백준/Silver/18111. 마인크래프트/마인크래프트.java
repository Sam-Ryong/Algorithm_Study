import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    static int B;

    static int setHeight(int x, int y, int height){

        int time = 0;
        if (height > map[x][y]){
            time = height - map[x][y];
            B = B - (height - map[x][y]);
        }
        else if(height < map[x][y]){
            time = (map[x][y] - height) * 2;
            B = B + (map[x][y]-height);
        }
        return time;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        B = Integer.parseInt(s[2]);

        map = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++){
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] > max)
                    max = map[i][j];
                if (map[i][j] < min)
                    min = map[i][j];
            }
        }
        int minTime = Integer.MAX_VALUE;
        int minTimeHeight = 0;
        int time = 0;
        int overhead;
        boolean tog ;
        int memory = B;
        for (int i = min; i < max + 1; i++){
            B = memory;
            time = 0;
            tog = true;
            for (int j = 0; j < N; j++){
                for (int k = 0; k < M; k++) {
                    overhead = setHeight(j,k,i);
                    time = time + overhead;
                }
            }
            if (B < 0){
                break;
            }
            if (time <= minTime){
                minTime = time;
                minTimeHeight = i;
            }

        }

        bw.write(minTime + " " + minTimeHeight);
        bw.flush();

    }


}