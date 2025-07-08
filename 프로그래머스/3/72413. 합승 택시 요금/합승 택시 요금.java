import java.lang.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] edges = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < n+1; j++){
                edges[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] fare : fares){
            edges[fare[0]][fare[1]] = fare[2];
            edges[fare[1]][fare[0]] = fare[2];
        }
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < n+1; j++){
                for (int k = 1; k < n+1; k++){
                    if (i == j){
                        edges[i][j] = 0;
                    }
                    else if (edges[i][k] != Integer.MAX_VALUE && edges[k][j] != Integer.MAX_VALUE){
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                        edges[j][i] = Math.min(edges[j][i], edges[j][k] + edges[k][i]);
                    }
                }
            }
        }
        
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < n+1; j++){
                for (int k = 1; k < n+1; k++){
                    if (i == j){
                        edges[i][j] = 0;
                    }
                    else if (edges[i][k] != Integer.MAX_VALUE && edges[k][j] != Integer.MAX_VALUE){
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                        edges[j][i] = Math.min(edges[j][i], edges[j][k] + edges[k][i]);
                    }
                }
            }
        }
        
        int sum = edges[s][a] + edges[s][b];
        
        for (int i = 1; i < n+1; i++){
            if (edges[s][i] != Integer.MAX_VALUE && edges[i][a] != Integer.MAX_VALUE && edges[i][b] != Integer.MAX_VALUE)
            sum = Math.min(sum, edges[s][i] + edges[i][a] + edges[i][b]);
        }
        
        // for (int i = 1; i < n+1; i++){
        //     for (int j = 1; j < n+1; j++){
        //         System.out.print(edges[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return sum;
    }
}