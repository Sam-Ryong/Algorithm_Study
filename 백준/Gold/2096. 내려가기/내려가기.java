import java.io.*;

public class Main {

    static int N;
    static int[][] table;
    static int[][] maxDP;
    static int[][] minDP;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        table = new int[N+1][3];
        minDP = new int[N+1][3];
        maxDP = new int[N+1][3];

        for (int i = 1; i < N+1; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0){
                    maxDP[i][j] = Math.max(maxDP[i-1][0],maxDP[i-1][1]) + table[i][j];
                    minDP[i][j] = Math.min(minDP[i-1][0],minDP[i-1][1]) + table[i][j];
                } else if (j == 1) {

                    maxDP[i][j] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + table[i][j];
                    minDP[i][j] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + table[i][j];

                }
                else if (j == 2){
                    maxDP[i][j] = Math.max(maxDP[i-1][1],maxDP[i-1][2]) + table[i][j];
                    minDP[i][j] = Math.min(minDP[i-1][1],minDP[i-1][2]) + table[i][j];
                }
            }
        }

        System.out.println(Math.max(maxDP[N][0], Math.max(maxDP[N][1],maxDP[N][2])) + " " + Math.min(minDP[N][0], Math.min(minDP[N][1],minDP[N][2])));

    }
}