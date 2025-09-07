import java.util.*;
import java.lang.*;

class Solution {
    int N = 0;
    int answer = 0;
    public int solution(int n) {
    
        N = n;
        
        for (int i = 0; i < n; i++){
            dfs(0,i,new ArrayList<Integer[]>());
        }

        
        return answer;
    }
    
    public void dfs(int r, int c, List<Integer[]> q){
        
        
        
        for (Integer[] queen : q){            
            Integer qr = queen[0];
            Integer qc = queen[1];
            
            if (qc.equals(c))
                return;
            if (Math.abs(qr - r) == Math.abs(qc - c))
                return;  
        }
        if (r == N-1){
            
            answer++;
            return;
        }
        for (int i = 0; i < N; i++){
            List<Integer[]> temp = new ArrayList<>();
            for (Integer[] queen : q){            
                Integer qr = queen[0];
                Integer qc = queen[1];
                temp.add(new Integer[]{qr, qc});
            }
            temp.add(new Integer[]{r,c});
            dfs(r+1, i, temp);
        }
        
        
    }
}