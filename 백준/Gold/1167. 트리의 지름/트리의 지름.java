import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int V;
    static Node[] nodes;

    static int result = 0;
    static int point = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node{
        ArrayList<Integer[]> edges = new ArrayList<>();
    }

    public static void dfs(int num, int distance, boolean[] prev){
        if (distance > result) {
            result = distance;
            point = num;
        }
        prev[num] = true;
        for (Integer[] edge : nodes[num].edges) {
            if (!prev[edge[0]])
                dfs(edge[0],distance + edge[1], prev);
        }
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        V = Integer.parseInt(s[0]);
        nodes = new Node[V+1];

        for (int i = 0; i < V; i++) {
            s = br.readLine().split(" ");
            nodes[Integer.parseInt(s[0])] = new Node();
            for (int j = 1; j < s.length; j = j + 2) {
                if (Integer.parseInt(s[j]) != -1) {
                    nodes[Integer.parseInt(s[0])].edges.add(new Integer[]{Integer.parseInt(s[j]), Integer.parseInt(s[j+1])});
                }
            }
        }

        dfs(1,0,new boolean[V+1]);
        result = 0;
        dfs(point,0,new boolean[V+1]);
        System.out.println(result);

    }
}