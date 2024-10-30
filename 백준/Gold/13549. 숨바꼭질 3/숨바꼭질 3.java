import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N,M;

    static int[] map = new int[100001];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void bfs(int time, ArrayList<Integer> location){
        ArrayList<Integer> temp = new ArrayList<>();
        while (true) {
            for (Integer i : location) {
                while (0 < i && i  < 100001) {
                    if (map[i] < 0) {
                        map[i] = time;
                        temp.add(i);

                    }
                    i = i * 2;
                }
                if (i==0 && map[i] < 0){
                    map[i] = time;
                    temp.add(i);
                }
            }
            if (map[M] >= 0){
                break;
            }
            time = time + 1;
            location.clear();
            for (Integer i : temp) {
                if (i > 0 && i < 100000){
                    if (map[i+1] < 0) {
                        location.add(i+1);
                    }
                    if (map[i-1] < 0) {
                        location.add(i-1);
                    }
                }
                if (i == 0){
                    if (map[i+1] < 0) {
                        location.add(i+1);
                    }
                }
                if (i == 100000){
                    if (map[i-1] < 0) {
                        location.add(i-1);
                    }
                }
            }
            if (map[M] >= 0){
                break;
            }
            temp.clear();

        }
    }


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100001; i++) {
            map[i] = -1;
        }
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        ArrayList<Integer> init = new ArrayList<>();
        init.add(N);
        bfs(0,init);
        System.out.println(map[M]);


    }
}
