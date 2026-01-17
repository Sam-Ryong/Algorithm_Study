import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int t, int c){ to = t; cost = c; }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Edge>[] adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++) adj[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            adj[A].add(new Edge(B, C));
            adj[B].add(new Edge(A, C));
        }

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        visited[1] = true;
        pq.addAll(adj[1]);

        int sum = 0, max = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(visited[e.to]) continue;
            visited[e.to] = true;
            sum += e.cost;
            max = Math.max(max, e.cost);
            for(Edge ne : adj[e.to]){
                if(!visited[ne.to]) pq.offer(ne);
            }
        }

        System.out.println(sum - max);
    }
}
