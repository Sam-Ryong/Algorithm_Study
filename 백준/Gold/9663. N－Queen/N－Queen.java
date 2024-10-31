import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[] board;

    static int result = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean check(int num){
        boolean able_to_attack = false;
        for (int i = 0; i < num; i++) {

            if (board[i] == board[num]) {
                able_to_attack = true;
                break;
            }
            if (Math.abs(board[i] - board[num]) == num - i) {
                able_to_attack = true;
                break;
            }

        }
        return able_to_attack;
    }

    public static void queen(int num){
        if (num == N-1){
            for (int i = 0; i < N; i++) {
                board[num] = i;
                if (!check(num)){
                    result++;
                }

            }
        }
        else {
            for (int i = 0; i < N; i++) {
                board[num] = i;
                if (!check(num))
                    queen(num + 1);

            }
        }

    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        board = new int[N];

        queen(0);

        System.out.println(result);



    }
}