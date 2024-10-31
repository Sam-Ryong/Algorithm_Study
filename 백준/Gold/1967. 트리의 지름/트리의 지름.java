import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int max = 0;

    static Node[] nodes;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node{
        ArrayList<Short[]> edges = new ArrayList<>();

    }

    public static void dfs(Node node,int dist, Node prev){
        if (node.edges.size() == 1 && prev != nodes[0]) {
            if (dist > max)
                max = dist;
            return;
        }
        for (Short[] i : node.edges) {
            if (nodes[i[0]] != prev)
                dfs(nodes[i[0]], dist + i[1],node);
        }
    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);

        nodes = new Node[N+1];

        for (int i = 0; i < N+1; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < N-1; i++) {
            s = br.readLine().split(" ");
            short a = Short.parseShort(s[0]);
            short b = Short.parseShort(s[1]);
            short c = Short.parseShort(s[2]);
            nodes[a].edges.add(new Short[]{b,c});
            nodes[b].edges.add(new Short[]{a,c});
        }
        for (int i = 1; i < N+1; i++) {
            if (nodes[i].edges.size() == 1) {
                dfs(nodes[i], 0, nodes[0]);
            }
        }

        System.out.println(max);



    }
}