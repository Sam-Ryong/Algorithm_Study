import java.io.*;
import java.util.*;

public class Main {

    static int N, M;




    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        System.out.println(N + M);
        System.out.println(N - M);
        System.out.println(N * M);
        System.out.println(N / M);
        System.out.println(N % M);

    }
}