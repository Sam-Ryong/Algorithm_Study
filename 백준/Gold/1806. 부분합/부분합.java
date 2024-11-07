import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static int N, S;

    static int[] numbers;

    static int min = Integer.MAX_VALUE;

    static int x = 0, y = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(s[i]);
        }
        int low = 0;
        int high = 0;
        int sum = numbers[0];

        while (true){
            if (sum >= S || high == N-1){
                if (sum >= S && min > high - low + 1){
                    min = high - low + 1;
                }
                sum -= numbers[low];
                low++;
                if (sum < S && high == N-1)
                    break;
            }
            else {
                high++;
                sum += numbers[high];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);


    }
}