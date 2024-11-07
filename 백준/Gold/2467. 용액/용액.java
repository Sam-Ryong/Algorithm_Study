import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int[] liq;

    static int min = Integer.MAX_VALUE;

    static int x = 0, y = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
    -8 -5 -4 -3 -2 -1
    0  1  2  3 4 5

    val = -8
    l, h = 1, 5
    mid = 3
    -3 + (-8) < 0
    h = 2

     */
    public static void binarySearch(int low, int high, int val){
        int mid = (low + high) / 2;
        while (high - low > 1){
            mid = (low + high) / 2;
            if (liq[mid] + val < 0){
                low = mid;
            }
            else {
                high = mid;
            }
        }

        if (Math.abs(liq[high] + val) <= min) {
            min = Math.abs(liq[high] + val);
            x = val;
            y = liq[high];
        }
        if (Math.abs(liq[low] + val) <= min) {
            min = Math.abs(liq[low] + val);
            x = val;
            y = liq[low];
        }
    }


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");
        liq = new int[N];
        for (int i = 0; i < N; i++) {
            liq[i] = Integer.parseInt(s[i]);
        }
        /*
        4
        -140 0 100 200

         */
        for (int i = 1; i < N; i++) {
            binarySearch(i,N-1,liq[i-1]);
        }

        System.out.println(x + " " + y);


    }
}