import java.io.*;
import java.util.BitSet;

public class Main {

    static int N, M;
    static int[] parents;
    static int[] ranks;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        parents = new int[N];
        ranks = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            if (result == 0) {
                if (find(A) == find(B)) {
                    result = i + 1;
                } else {
                    union(A, B);
                }
            }


        }
        System.out.println(result);
    }

    public static int find(int num){
        if (parents[num] != num){
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (ranks[rootX] > ranks[rootY]) {
                parents[rootY] = rootX;
            } else if (ranks[rootX] < ranks[rootY]) {
                parents[rootX] = rootY;
            } else {
                parents[rootY] = rootX;
                ranks[rootX]++;
            }
        }
    }
}
