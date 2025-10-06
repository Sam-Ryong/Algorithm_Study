import java.util.*;
import java.lang.*;

class Solution {
    Node[] nodes;
    int[] answer = new int[2];
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        nodes = new Node[n+1];
        Arrays.sort(summits);
        for (int[] path : paths){
            int i = path[0];
            int j = path[1];
            int w = path[2];
            
            if (nodes[i] == null){
                nodes[i] = new Node();
                nodes[i].num = i;
            }
            if (nodes[j] == null){
                nodes[j] = new Node();
                nodes[j].num = j;
            }
            Edge edge = new Edge();
            edge.n1 = nodes[i];
            edge.n2 = nodes[j];
            edge.time = w;
            
            nodes[i].edges.add(edge);
            nodes[j].edges.add(edge);
        }
        
        
        for (int i = 0; i < summits.length; i++){
            int summit = summits[i];
            int[] dist = new int[n+1];
            Comparator<Edge> cmp = (a,b) -> Integer.compare(a.time, b.time);
            boolean[] visit = new boolean[n+1];
            boolean[] isEnd = new boolean[n+1];
            Queue<Edge> temp = new PriorityQueue<>(cmp);
            temp.addAll(nodes[summit].edges);
            visit[summit] = true;
             for (int k = 0; k < summits.length; k++){
                 visit[summits[k]] = true;
             }
            for (int k = 0; k < gates.length; k++){
                 isEnd[gates[k]] = true;
             }
            int count = 0;
            while (count < n - summits.length){
                while (!temp.isEmpty() && (visit[temp.peek().n1.num] && visit[temp.peek().n2.num])){
                    temp.poll();
                }
                if (temp.isEmpty())
                    break;
                Edge edge = temp.poll();
                Node node = visit[edge.n1.num] ? edge.n2 : edge.n1;
                Node other = visit[edge.n1.num] ? edge.n1 : edge.n2;
                visit[node.num] = true;
               
                dist[node.num] = Math.max(dist[other.num], edge.time);
                if (isEnd[node.num]){
                    if (dist[node.num] < answer[1]){
                        answer[0] = summit;
                        answer[1] = dist[node.num];
                    }
                    break;
                }
                temp.addAll(node.edges);
                count++;
            }
  
        }
        return answer;
    }

    
    class Node{
        int num;
        int type;
        List<Edge> edges = new ArrayList<>();
    }
    
    class Edge{
        Node n1;
        Node n2;
        int time;
    }
    

}