import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int V,E,K;

    static Node[] nodes;
    static int[] result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node{
        int val;
        Map<Integer, Integer> edge = new HashMap<>();

        public void setEdge(int val, int distance) {
            if (edge.get(val) == null){
                edge.put(val,distance);
            }
            else {
                if (edge.get(val) > distance){
                    edge.replace(val,distance);
                }
            }
        }
    }

    public static void dijkstra(){
        int next = K;
        boolean[] visit = new boolean[V+1];
        Map<Integer, Integer> nextEdge = new HashMap<>();
        Map<Integer, Integer> temp = new HashMap<>();
        nextEdge.putAll(nodes[next].edge);
        result[next] = 0;
        visit[next] = true;
        int count = 0;
        while (count < V){
            int min = Integer.MAX_VALUE;
            int minNum = next;
            for (Integer i : nextEdge.keySet()) {
                if (!visit[i]) {
                    //temp.put(i,nextEdge.get(i));
                    result[i] = Math.min(result[i], result[next] + nextEdge.get(i));
                }
            }
            for (int i = 0; i < V+1; i++) {
                if (!visit[i] && result[i] < min) {
                    min = result[i];
                    minNum = i;
                }
            }
            next = minNum;
            visit[next] = true;
            nextEdge.clear();
            nextEdge.putAll(nodes[next].edge);
            count++;
        }

    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");

        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        K = Integer.parseInt(br.readLine());
        nodes = new Node[V+1];
        result = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            nodes[i] = new Node();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            nodes[u].setEdge(v,w);
        }

        dijkstra();

        for (int i = 1; i < V+1; i++) {
            if(result[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(String.valueOf(result[i])+"\n");
        }

        bw.flush();

    }
}