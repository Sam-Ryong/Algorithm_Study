import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static int N;

    static int[] seq1, seq2;
    static int[] DP1;
    static int[] DP2;



    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        seq1 = new int[N];
        seq2 = new int[N];
        DP1 = new int[N]; // DP1[i]는 i가 최대인 증가하는 수열의 길이
        DP2 = new int[N]; // DP2[i]는 i가 최소인 감소하는 수열의 길이
        s = br.readLine().split(" ");
        DP1[0] = 1;
        DP2[0] = 1;
        for (int i = 0; i < N; i++) {
            seq1[i] = Integer.parseInt(s[i]);
            seq2[i] = Integer.parseInt(s[N-1-i]);
        }
        for (int i = 1; i < N; i++) {
            int max1 = 0;
            int max2 = 0;
            for (int j = 0; j < i; j++) {
                if (seq1[j] < seq1[i] && DP1[j] > max1){
                    max1 = DP1[j];
                }
                if (seq2[j] < seq2[i] && DP2[j] > max2){
                    max2 = DP2[j];
                }
            }
            DP1[i] = max1 + 1;
            DP2[i] = max2 + 1;
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (result < DP1[i] + DP2[N-1-i])
                result = DP1[i] + DP2[N-1-i];
        }

        System.out.println(result-1);
            
    }
}
//과연