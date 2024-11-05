import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void bfs(){
        ArrayList<Integer> next = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int[] info = new int[100001];
        boolean[] visit = new boolean[100001];
        info[N] = 1;
        visit[N] = true;
        next.add(N);
        int time = 0;
        boolean isFound = false;
        while (true){
            time++;
            for (Integer num : next) {

                if (num > 0) {
                    if (info[num-1] == 0) {
                        temp.add(num - 1);
                    }
                    if (!visit[num-1]) {
                        info[num - 1] += info[num];
                    }
                    if (num - 1 == M) {
                        isFound = true;

                    }
                }
                if (num < 100000) {
                    if (info[num+1] == 0) {
                        temp.add(num + 1);
                    }
                    if (!visit[num+1]) {
                        info[num + 1] += info[num];
                    }
                    if (num + 1 == M) {
                        isFound = true;

                    }
                }
                if (num * 2 <= 100000) {
                    if (info[num * 2] == 0) {
                        temp.add(num * 2);
                    }
                    if (!visit[num * 2]) {
                        info[num * 2] += info[num];
                    }
                    if (num * 2 == M) {
                        isFound = true;

                    }
                }

            }
            for (Integer i : temp) {
                visit[i] = true;
            }
            if (isFound)
                break;
            next.clear();
            next.addAll(temp);
            temp.clear();
        }
        if (M != N) {
            System.out.println(time);
            System.out.println(info[M]);
        }
        else {
            System.out.println(0);
            System.out.println(1);
        }
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        bfs();

    }
}