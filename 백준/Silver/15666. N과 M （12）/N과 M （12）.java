import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static ArrayList<Integer> numbers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int num, String string, int count) throws IOException {
        if (count == M){
            bw.write(string +"\n");
            return;
        }
        for (int i = num; i < numbers.size(); i++) {
            dfs(i, string+numbers.get(i)+" ",count+1);
        }
    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(s[i]));
        }

        Collections.sort(numbers);

        for (int i = N-1; i > 0; i--) {
            if (numbers.get(i).equals(numbers.get(i - 1)))
                numbers.remove(i);
        }
        dfs(0, "",0);

        bw.flush();


    }
}