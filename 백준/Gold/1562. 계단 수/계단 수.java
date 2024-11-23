import java.io.*;

public class Main {

    static int N;

    static int[][][] DP;


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
    10 : 9876543210
    11 : 89876543210, 98765432101, 10123456789
    12 :
     */

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);

        DP = new int[N+1][10][1024];

        for (int i = 1; i < 10; i++) {
            DP[1][i][1 << i] = 1;
        }

        for (int i = 2; i < N+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    if (j == 0)
                        DP[i][j][k | (1 << j)] = (DP[i][j][k | (1 << j)] + DP[i-1][1][k]) % 1000000000;
                    else if (j < 9)
                        DP[i][j][k | (1 << j)] = (DP[i][j][k | (1 << j)] + DP[i-1][j-1][k] + DP[i-1][j+1][k]) % 1000000000;
                    else
                        DP[i][j][k | (1 << j)] = (DP[i][j][k | (1 << j)] + DP[i-1][8][k])% 1000000000;

                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + DP[N][i][1023];
            sum = sum % 1000000000;
        }
        System.out.println(sum);



    }
}