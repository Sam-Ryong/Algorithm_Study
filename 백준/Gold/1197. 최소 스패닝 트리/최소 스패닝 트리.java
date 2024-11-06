import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static int V, E;
    static Node[] nodes;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node{
        int num;
        ArrayList<Edge> edges = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    public static class Edge implements Comparable<Edge>{
        Node start;
        Node end;
        int weight;

        public Edge(Node start, Node end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V+1];
        pq.offer(new Edge(nodes[0],nodes[1],0));
        int result = 0;
        for (int i = 0; i < V; i++) {
            Edge minEdge = pq.poll();
            while (visit[minEdge.end.num]){
                minEdge = pq.poll();
            }
            result += minEdge.weight;
            visit[minEdge.end.num] = true;
            for (Edge edge : minEdge.end.edges) {
                if (!visit[edge.end.num])
                    pq.offer(edge);
            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        nodes = new Node[V+1];
        for (int i = 0; i < V+1; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            nodes[Integer.parseInt(s[0])].edges.add(new Edge(nodes[Integer.parseInt(s[0])],nodes[Integer.parseInt(s[1])], Integer.parseInt(s[2])));
            nodes[Integer.parseInt(s[1])].edges.add(new Edge(nodes[Integer.parseInt(s[1])],nodes[Integer.parseInt(s[0])], Integer.parseInt(s[2])));
        }
        System.out.println(dijkstra());
    }
}