import javax.swing.plaf.PanelUI;
import java.io.*;
import java.net.CookieHandler;
import java.util.*;

public class Main {

    static int N;

    static int[] numbers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int bnSearch(int low, int high, int val, ArrayList<Integer> arr){
        int mid = (low + high) / 2;
        while (high > low) {
            if (arr.get(mid) >= val) {
                high = mid;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        numbers = new int[N + 1];

        ArrayList<Integer> result = new ArrayList<>();

        s = br.readLine().split(" ");

        for (int i = 1; i < N+1; i++) {
            numbers[i] = Integer.parseInt(s[i-1]);
        }

        result.add(numbers[1]);

        for (int i = 2; i < N+1; i++) {
            if (result.get(result.size()-1) < numbers[i]){
                result.add(numbers[i]);
            }
            else {
                int where = bnSearch(0, result.size(), numbers[i], result);
                result.set(where, numbers[i]);
            }
        }

        System.out.println(result.size());

    }
}