import java.lang.*;

class Solution {
        
    int[][] edge;
    int n = -1;
    int answer = Integer.MAX_VALUE;
    int count = 0;
        
    public int solution(int n, int[][] wires) {
        
        this.n = n;
        edge = new int[n+1][n+1];
        
        for (int[] wire : wires){
            edge[wire[0]][wire[1]] = 1;
            edge[wire[1]][wire[0]] = 1;
        }
        
        
        String visit = "";
        for (int i = 0; i < n+1; i++){
            visit += "0";
        }
        for (int[] wire : wires){
            dfs(1,visit,wire);
            int a = count;
            int b = n - count;
            answer = Math.min((int)Math.abs(b-a),answer); 
            count = 0;
                
        }
        
        return answer;
        
        
    }
    
    void dfs(int now, String visit, int[] ex){
        
        if (visit.charAt(now) == '1'){
            return;
        }
        count++;
        visit = visit.substring(0,now) + "1" + visit.substring(now+1);
        for (int i = 1; i < n+1; i++){
            if (edge[now][i] > 0){
                if (!((now == ex[0] && i == ex[1]) || (now == ex[1] && i == ex[0])))
                    dfs(i,visit,ex);
            }
        }
        
    }
    
    
}