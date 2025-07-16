import java.lang.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[][] edges = new int[N+1][N+1];
        
        for (int i = 1; i < N+1; i++){
            for (int j = 1; j < N+1; j++){
                edges[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] r : road){
            edges[r[0]][r[1]] = Math.min(edges[r[0]][r[1]],r[2]);
            edges[r[1]][r[0]] = Math.min(edges[r[1]][r[0]],r[2]);
        }
        
        for (int i = 1; i < N+1; i++){
            for (int j = 1; j < N+1; j++){
                for (int k = 1; k < N+1; k++){
                   
                    if (i != j && edges[i][k] != Integer.MAX_VALUE && edges[k][j] != Integer.MAX_VALUE){
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                        edges[j][i] = edges[i][j];
                    }
                   
                }
            }
        }
        
        for (int i = 1; i < N+1; i++){
            for (int j = 1; j < N+1; j++){
                for (int k = 1; k < N+1; k++){
                   
                    if (i != j && edges[i][k] != Integer.MAX_VALUE && edges[k][j] != Integer.MAX_VALUE){
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                        edges[j][i] = edges[i][j];
                    }
                   
                }
            }
        }

        
        
        for (int i = 2; i < N+1; i++){
      
            if (edges[1][i] <= K)
                answer++;
            
        }

        return answer;
    }
}