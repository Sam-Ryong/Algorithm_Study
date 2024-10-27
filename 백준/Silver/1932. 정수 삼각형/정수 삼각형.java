import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int A, B, C;

    static long max = Long.MIN_VALUE;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);

        ArrayList<Integer[]> nodes = new ArrayList<>();
        ArrayList<Long[]> DP = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            s = br.readLine().split(" ");
            nodes.add(new Integer[i+1]);
            DP.add(new Long[i+1]);
            for (int j = 0; j < i+1; j++) {
                nodes.get(i)[j] = Integer.parseInt(s[j]);
                DP.get(i)[j] = (long) 0;
            }
        }
        DP.get(0)[0] = DP.get(0)[0] + nodes.get(0)[0];

        for (int i = 1; i < A; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j > 0 && j < i) {
                    DP.get(i)[j] = Math.max(DP.get(i-1)[j-1], DP.get(i-1)[j]) + nodes.get(i)[j];
                }
                else if (j == 0){
                    DP.get(i)[j] = DP.get(i-1)[j] + nodes.get(i)[j];
                }
                else if (j == i){
                    DP.get(i)[j] = DP.get(i-1)[j-1] + nodes.get(i)[j];
                }
            }
        }

        Arrays.sort(DP.get(DP.size()-1));

        System.out.println(DP.get(DP.size()-1)[DP.get(DP.size()-1).length-1]);
    }
}