import java.lang.*;
import java.util.*;

class Solution {
    
    int answer = 0;
    int k;
    int[][] edges;
    Node[] nodes;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.k = k;
        this.edges = edges;
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++){
            nodes[i] = new Node();
            nodes[i].num = i;
        }
        for (int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            
            nodes[x].next.put(type, nodes[y]);
            nodes[y].next.put(type, nodes[x]);
           
        }
        dfs(0,0, infected.clone(), 1);
        return answer;
    }
    
    class Node{
        int num;
        HashMap<Integer, Node> next = new HashMap<>();
    }
    
    void dfs(int open, int count, boolean[] infected, int infectedCount){
        
        if (count == k+1){
            answer = Math.max(answer, infectedCount);
            if (answer == infectedCount){
                // for(boolean b : infected){
                //     System.out.print(b ? 1 : 0);
                // }
                // System.out.println();
            }
            return;
        }
        // for(boolean b : infected){
        //             System.out.print(b ? 1 : 0);
        //         }
        //         System.out.println();
        boolean changed = true;
        while (changed){
            changed = false;
            for (int[] edge : edges){
                int x = edge[0];
                int y = edge[1];
                int type = edge[2];
                if (type != open)
                    continue;
                if (infected[x] && !infected[y]){
                    infected[y] = true;
                    changed = true;
                    infectedCount++;
                }
                else if (!infected[x] && infected[y]){
                    infectedCount++;
                    infected[x] = true;
                    changed = true;
                }
            }
        }
        
        if (open != 1)
            dfs(1,count + 1, infected.clone(), infectedCount);
        if (open != 2)
            dfs(2,count + 1, infected.clone(), infectedCount);
        if (open != 3)
            dfs(3,count + 1, infected.clone(), infectedCount);
        
    }
}