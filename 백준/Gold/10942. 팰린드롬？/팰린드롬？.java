import java.io.*;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class Main {

    static int N, M;
    static int[] numbers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int isAnswer(int s, int e){
        int left = (s+e)/2;
        int right = (s+e+1)/2;
        int result = 1;
        while ((left >= s) && (right <= e)){
            if(numbers[left] != numbers[right]){
                result = 0;
                break;
            }
            left--;
            right++;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        numbers = new int[N+1];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i+1] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int S = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            bw.write(isAnswer(S,E)+"\n");

        }

        bw.flush();


    }
}