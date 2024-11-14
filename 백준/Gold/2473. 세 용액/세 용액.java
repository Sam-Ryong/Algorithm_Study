import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static long[] liquids;

    static long min = Long.MAX_VALUE;
    static long[] answer = new long[3];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
    -3 -1 1 2 3 4 5
     */
    public static void search(){
        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                int index = bnSearch(j + 1, N - 1, liquids[i] + liquids[j]);
                if (Math.abs(liquids[i] + liquids[j] + liquids[index]) < min){
                    min = Math.abs(liquids[i] + liquids[j] + liquids[index]);
                    answer[0] = liquids[i];
                    answer[1] = liquids[j];
                    answer[2] = liquids[index];
                }
                if (index > (j + 1)  && Math.abs(liquids[i] + liquids[j] + liquids[index-1]) < min) {
                    min = Math.abs(liquids[i] + liquids[j] + liquids[index-1]);
                    answer[0] = liquids[i];
                    answer[1] = liquids[j];
                    answer[2] = liquids[index-1];
                }
                if (index < N - 1 && Math.abs(liquids[i] + liquids[j] + liquids[index+1]) < min) {
                    min = Math.abs(liquids[i] + liquids[j] + liquids[index+1]);
                    answer[0] = liquids[i];
                    answer[1] = liquids[j];
                    answer[2] = liquids[index+1];
                }

            }
        }
    }
    public static int bnSearch(int low, int high, long val){
        int mid = (low + high)/2;
        while (high > low){
            if (liquids[mid] + val >= 0){
                high = mid;
            }
            else {
                low = mid + 1;
            }
            mid = (low + high)/2;
        }
        //int result = mid;
        return mid;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        liquids = new long[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquids[i] = Long.parseLong(s[i]);
        }
        Arrays.sort(liquids);
        search();
        for (int i = 0; i < 3; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}