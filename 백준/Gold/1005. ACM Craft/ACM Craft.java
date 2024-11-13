import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int N,M;
    static Building[] builds;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Building{
        int time;
        ArrayList<Integer> next = new ArrayList<>();
        ArrayList<Integer> before = new ArrayList<>();

        public Building(int time) {
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        T = Integer.parseInt(s[0]);
        for (int i = 0; i < T; i++) {
            s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            builds = new Building[N+1];
            int[] minStartTime = new int[N+1];
            s = br.readLine().split(" ");
            int[] degree = new int[N+1];
            for (int j = 1; j < N+1; j++) {
                builds[j] = new Building(Integer.parseInt(s[j-1]));
            }
            for (int j = 1; j < M+1; j++) {
                s = br.readLine().split(" ");
                builds[Integer.parseInt(s[0])].next.add(Integer.parseInt(s[1]));
                builds[Integer.parseInt(s[1])].before.add(Integer.parseInt(s[0]));
                degree[Integer.parseInt(s[1])]++;
            }
            s = br.readLine().split(" ");
            int target = Integer.parseInt(s[0]);
            Queue<Integer> queue = new ArrayDeque<>();
            for (int j = 1; j < N+1; j++) {
                if(degree[j] == 0){
                    minStartTime[j] = builds[j].time;
                }
            }
            while (true){
                for (int j = 1; j < N+1; j++) {
                    if(degree[j] == 0){
                        queue.offer(j);
                        degree[j] = -1;
                    }
                }

                Integer num = queue.poll();
                if (num == target)
                    break;

                for (Integer next : builds[num].next) {
                    minStartTime[next] = Math.max(minStartTime[next],minStartTime[num] + builds[next].time);
                    degree[next]--;
                }
            }
            bw.write((minStartTime[target]) + "\n");


        }
        bw.flush();

    }
}