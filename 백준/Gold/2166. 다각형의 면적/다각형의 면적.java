import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N;

    static long[][] points;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        points = new long[N][2];
        long A = 0;
        long B = 0;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(s[0]);
            points[i][1] = Integer.parseInt(s[1]);
            if (i >= 1) {
                A = A + points[i - 1][0] * points[i][1];
                B = B + points[i - 1][1] * points[i][0];
            }
        }
        B += points[0][0] * points[N-1][1];
        A += points[0][1] * points[N-1][0];

        double result = 0.5 * Math.abs(A-B);
        System.out.printf("%.1f",result);

    }
}