import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void star() {

    }


    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        //int width = (int) (Math.log((double) N / 3)/Math.log(2));

        int width = (N / 3) * 6;
        int leftMargin = width / 2 - 3;
        int rightMargin = width / 2;
        int count = 2;
        String[] stars = new String[]{"  *   ", " * *  ", "***** "};
        StringBuilder now = new StringBuilder();
        StringBuilder prev = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < leftMargin; i++) {
            prev.append(" ");
        }
        prev.append(stars[0]);
        for (int i = 0; i < leftMargin; i++) {
            prev.append(" ");
        }
        prev.append("\n");
        bw.write(prev.toString());
        while (count <= N) {
            for (int i = 0; i < leftMargin; i++) {
                now.append(" ");
            }
            int index = (count - 1) % 3;
            for (int i = leftMargin; i < leftMargin + (count - 1) / 3 + 1; i++) {
                int cur = now.length();
                if (index == 0){
                    if (!(prev.substring(cur, cur + 1).equals(prev.substring(cur + 5,cur+6)))) {
                        now.append(stars[index]);
                    } else {
                        now.append("      ");
                    }
                } else if (index == 1) {
                    if (prev.substring(cur + 2, cur + 3).equals("*")) {
                        now.append(stars[index]);
                    } else {
                        now.append("      ");
                    }
                } else if (index == 2){
                    if(prev.substring(cur + 1, cur + 2).equals("*")) {
                        now.append(stars[index]);
                    }
                    else{
                        now.append("      ");
                    }
                }
            }
            for (int i = 0; i < leftMargin; i++) {
                now.append(" ");
            }
            if (count % 3 == 0)
                leftMargin = leftMargin - 3;
            count++;
            now.append("\n");
            bw.write(now.toString());
            prev.delete(0, prev.length());
            prev.append(now);
            now.delete(0, now.length());
        };
        bw.flush();
    }
}