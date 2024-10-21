import java.io.*;
import java.util.*;

public class Main {

    static int T;

    public static long kaing(int M, int N, long x, long y){
        long result = -1;
        long firstMax = Math.max(M,N);
        long secondMax = Math.min(M,N);
        long first = M > N ? x : y;
        long second = M > N ? y : x;
        long MAX = M*N;
        int count = 0;
        while(true){
            if (first % secondMax == second % secondMax){
                result = first;
                break;
            }
            first += firstMax;

            if (first > MAX)
                break;

        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int N = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);
            long result = kaing(M,N,x,y);
            bw.write(String.valueOf(result));
            if (i != T - 1)
                bw.write("\n");

        }

        bw.flush();

    }
}

/*
3 6

1 1
2 2
3 3
1 4
2 5
3 1
1 2
2 3
3 4
1 5
2 1
3 2
1 3
2 4
3 5

 */