import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static int N;

    static int[][] W;
    static int[][] DP;

    static ArrayList<Integer> memo = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int sum, int now, int visit){

    }
    /*
    0001 1
    0010 2
    0100 4
    1000 8

    0011 3
    0101 5
    1001 9
    0110 6
    1010 10
    1100 12

    0111 7
    1110 14

    1111 15


     */

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        W = new int[N+1][N+1];
        DP = new int[1 << (N)][N+1];
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N+1; j++) {
                DP[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < N+1; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j < N+1; j++) {
                W[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        ArrayList<Integer> adders = new ArrayList<>();
        ArrayList<Integer> now = new ArrayList<>();
        ArrayList<Integer> next = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            DP[1 << i][i+1] = W[1][i+1];
            now.add(1 << i);
            adders.add(1 << i);
        }
        now.remove(0);
        adders.remove(0);

        while (now.size() > 0){
            for (Integer bit : now) {
                for (int i = 2; i < N+1; i++) {
                    for (int j = 0; j < adders.size(); j++) {
                        if (DP[bit][i] == Integer.MAX_VALUE || DP[bit][i] == 0)
                            break;
                        int adder = adders.get(j);
                        if (((bit & adder) == 0)) {
                            if (DP[bit + adder][j+2] == Integer.MAX_VALUE && W[i][j+2] != 0)
                                next.add(bit+adder);
                            if(DP[bit][i] != Integer.MAX_VALUE && W[i][j+2] != 0)
                                DP[bit + adder][j+2] = Math.min(DP[bit + adder][j+2], DP[bit][i] + W[i][j+2]);


                        }
                    }

                }
            }
            now.clear();
            now.addAll(next);
            next.clear();
        }
        int result = Integer.MAX_VALUE;
        for (int i = 2; i < N+1; i++) {
            if (DP[(1<<N)-2][i] != Integer.MAX_VALUE && W[i][1] != 0)
                result = Math.min(result,DP[(1<<N)-2][i] + W[i][1]);
        }
        System.out.println(result);
        /*
        for (int[] ints : DP) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }



        2(0010) : 0 1 0 0
        6(0110) : 0 0 2 0
        10(1010) : 0 0 0 2
        14               3

         */
    }
}