import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;

public class Main {

    static int T, N;

    static Singer[] singers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Singer{
        ArrayList<Integer> next = new ArrayList<>();
    }
    
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        T = Integer.parseInt(s[0]);

        for (int i = 0; i < T; i++) {
            s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);

            int[] degree = new int[N+1];
            int[] choice = new int[N+1];
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                choice[j+1] = Integer.parseInt(s[j]);
                degree[Integer.parseInt(s[j])]++;
            }
            int count = 0;
            ArrayList<Integer> next = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 1; j < N+1; j++) {
                if (degree[j] == 0){
                    next.add(j);
                }
            }
            while (true){
                boolean modified = false;
                for (Integer integer : next) {
                    count++;
                    degree[integer] = -1;
                    degree[choice[integer]]--;
                    if (degree[choice[integer]] == 0)
                        temp.add(choice[integer]);
                    modified = true;
                }

                if (!modified)
                    break;

                next.clear();
                next.addAll(temp);
                temp.clear();
            }
            bw.write(count+"\n");

        }
        bw.flush();


    }
}