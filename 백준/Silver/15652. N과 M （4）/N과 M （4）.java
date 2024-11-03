import java.io.*;

public class Main {

    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int num, String string, int count) throws IOException {
        if (count == M){
            bw.write(string +"\n");
            return;
        }
        for (int i = num; i <= N; i++) {
            dfs(i, string+i+" ",count+1);
        }
    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        dfs(1,"",0);

        bw.flush();


    }
}