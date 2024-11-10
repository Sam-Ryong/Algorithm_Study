import com.sun.security.auth.NTSid;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static int[][] DP;
    static int[][] DP2;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

     /*
       C A P C A K
     A 0 1 1 1 1 1
     C 1 1 1 2 2 2
     A
     Y
     K
     P
     */

    public static void main(String[] args) throws IOException {
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        DP = new int[A.length+1][B.length+1];
        DP2 = new int[A.length][2];

        for (int i = 1; i < A.length+1; i++) {
            for (int j = 1; j < B.length+1; j++) {
                if (A[i-1] == B[j-1]){
                    DP[i][j] = DP[i-1][j-1] + 1;
                }
                else {
                    DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);
                }
            }
        }

        int max = DP[A.length][B.length];
        char[] result = new char[max];
        bw.write(max + "\n");
        int prevR = A.length+1;
        int prevB = B.length+1;

        for (int diagonal = A.length + B.length ; diagonal > 1; diagonal--) {
            for (int i = Math.min(diagonal,A.length); (diagonal - i < B.length+1) && i > 0; i--) {
                if ((DP[i][diagonal-i] == max) && (DP[i-1][diagonal-i] == max - 1) && (DP[i][diagonal-i-1] == max - 1)){
                    if ((i < prevR) && ((diagonal - i) < prevB)){
                        prevR = i;
                        prevB = diagonal - i;
                        max--;
                        result[max] = A[i-1];
                        break;
                    }
                }
            }
        }
        for (char c : result) {
            bw.write(c);
        }
        bw.flush();






    }

}