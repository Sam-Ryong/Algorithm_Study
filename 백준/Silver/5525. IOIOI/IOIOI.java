import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static char[] ioi;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ioi = br.readLine().toCharArray();

        int count = 1;
        int result = 0;
        ArrayList<Integer> iois = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (ioi[i] == 'I') {
                if (i < M - 2 && ioi[i+1] == 'O' && ioi[i+2] == 'I'){
                    i = i + 1;
                    count = count + 2;
                }
                else {
                    if (count >= 2 * N + 1)
                        result = result + ((count-1-2*N)/2) + 1;
                    count = 1;
                }
            }
        }
        System.out.println(result);

    }
}