import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static Singer[] singers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Singer{
        ArrayList<Integer> next = new ArrayList<>();
    }
    
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        singers = new Singer[N+1];

        for (int i = 0; i < N+1; i++) {
            singers[i] = new Singer();
        }
        int[] degree = new int[N+1];
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int length = Integer.parseInt(s[0]);
            for (int j = 2; j < length+1; j++) {
                singers[Integer.parseInt(s[j-1])].next.add(Integer.parseInt(s[j]));
                degree[Integer.parseInt(s[j])]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if (degree[i] == 0){
                queue.offer(i);
                degree[i] = -1;
            }
        }
        int count = 0;
        while (count < N){
            Integer singer = queue.poll();
            if (singer == null) {
                System.out.println(0);
                return;
            }

            bw.write(singer + "\n");
            for (Integer next : singers[singer].next) {
                degree[next]--;
            }
            for (int i = 1; i < N+1; i++) {
                if (degree[i] == 0){
                    queue.offer(i);
                    degree[i] = -1;
                }
            }
            count++;
        }
        bw.flush();

    }
}