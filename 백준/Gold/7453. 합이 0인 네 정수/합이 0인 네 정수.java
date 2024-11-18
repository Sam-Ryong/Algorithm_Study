import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;

    static long[] A;
    static long[] B;
    static long[] C;
    static long[] D;

    static long[] CD;


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static long bnSearch(int low, int high, long val){
        int mid = (low + high)/2;
        while (high > low){
            if (CD[mid] >= val){
                high = mid;
            }
            else {
                low = mid + 1;
            }
            mid = (low + high)/2;
        }

        if (CD[mid] == val){
            high = N*N;
            low = 0;
            int mid2 = (low + high)/2;
            val = val + 1;
            while (high > low){
                if (CD[mid2] >= val){
                    high = mid2;
                }
                else {
                    low = mid2 + 1;
                }
                mid2 = (low + high)/2;
            }
            return (long) mid2 - mid;
        }
        return (long) 0;

    }
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        A = new long[N];
        B = new long[N];
        C = new long[N];
        D = new long[N];

        long[] AB = new long[N * N];
        CD = new long[N * N];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            A[i] = Integer.parseInt(s[0]);
            B[i] = Integer.parseInt(s[1]);
            C[i] = Integer.parseInt(s[2]);
            D[i] = Integer.parseInt(s[3]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[N*i+j] = A[i] + B[j];
                CD[N*i+j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

/*        System.out.println(Arrays.toString(AB));
        System.out.println(Arrays.toString(CD));*/

        long result = 0;
        for (int i = 0; i < N*N; i++) {
            long count = bnSearch(0, N * N - 1, AB[i] * (-1));
            result = result + count;
        }

        System.out.println(result);


    }
}