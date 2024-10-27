import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static long A, B, C;

    static int min = Integer.MAX_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        A = Long.parseLong(s[0]);
        B = Long.parseLong(s[1]);
        C = Long.parseLong(s[2]);

        long initA = A % C;
        boolean[] bits = new boolean[32];
        long[] values = new long[32];
        for (int i = 0; i < 32; i++) {
            if ((B & (int) Math.pow(2,i)) == Math.pow(2,i)){
                bits[i] = true;
            }
        }
        values[0] = A;
        for (int i = 1; i < 32; i++) {
            values[i] = (values[i-1] * values[i-1]) % C;
        }

        long result = 1;

        for (int i = 0; i < 32; i++) {
            if (bits[i])
                result = (result * values[i]) % C;
        }

        System.out.println(result);

    }
}