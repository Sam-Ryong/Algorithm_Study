import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    static int A, B;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int bfs(){
        ArrayList<Long> next = new ArrayList<>();
        ArrayList<Long> temp = new ArrayList<>();
        next.add((long) A);
        boolean found = false;
        int count = 0;
        while (next.size() > 0){
            count++;
            for (Long i : next) {
                if (i == B) {
                    found = true;
                    break;
                }
                else if (i < B){
                    temp.add(i*2);
                    temp.add(i*10 + 1);
                }
            }
            if (found)
                break;

            next.clear();
            next.addAll(temp);
            temp.clear();
        }
        if (!found)
            return -1;
        return count;
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);

        System.out.println(bfs());

    }
}