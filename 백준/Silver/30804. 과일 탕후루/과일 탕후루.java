import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] fruit;

    static public int countKind(int[] count){
        int result = 0;
        for (int i : count) {
            if (i > 0)
                result++;
        }
        return result;

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = {0,0,0,0,0,0,0,0,0,0};
        int kinds = 0;

        String s = br.readLine();
        N = Integer.parseInt(s);
        fruit = new int[N];


        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++){
            fruit[i] = Integer.parseInt(input[i]);
        }
        int start = 0;
        int end = 0;
        int kind = 1;
        int max = 1;
        count[fruit[0]]++;
        while(start <= N-1){
            if (kind <= 2 && end < N - 1) {
                end++;
                if (count[fruit[end]] == 0){
                    kind++;
                }
                count[fruit[end]]++;
            }
            else{
                count[fruit[start]]--;
                if (count[fruit[start]] == 0)
                    kind--;
                start++;
            }
            if (kind <= 2){
                if (end - start + 1> max)
                    max = end - start + 1;
            }


        }
        System.out.println(max);

    }
}