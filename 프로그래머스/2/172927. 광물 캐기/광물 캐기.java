import java.lang.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        
        
        dfs(0, 0, 0, 0, picks, minerals);
       
        dfs(0, 1, 0, 0, picks, minerals);
      
        dfs(0, 2, 0, 0, picks, minerals);
        
        return answer;
    }
    
    void dfs(int mineral, int pick, int pickCount, int cost, int[] picks, String[] minerals){
        
   
        
        
        if (mineral == minerals.length){
            answer = Math.min(answer, cost);
            return;
        }
        if (picks[0] + picks[1] + picks[2] == 0){
            answer = Math.min(answer, cost);
            return;
        }
        if (picks[pick] == 0)
            return;
        
        int[] temp = new int[3];
        temp[0] = picks[0];
        temp[1] = picks[1];
        temp[2] = picks[2];
        
        if (minerals[mineral].equals("diamond")){
            if (pick == 0)
                cost += 1;
            else if (pick == 1)
                cost += 5;
            else if (pick == 2)
                cost += 25;
        }
        
        else if (minerals[mineral].equals("iron")){
            if (pick == 0)
                cost += 1;
            else if (pick == 1)
                cost += 1;
            else if (pick == 2)
                cost += 5;
        }
        
        else if (minerals[mineral].equals("stone")){
            cost += 1;
        }
            
            
        
        if (pickCount == 4){
            pickCount = 0;
            temp[pick]--;
           
            dfs(mineral+1, 0, 0, cost, temp, minerals);
            
            dfs(mineral+1, 1, 0, cost, temp, minerals);
            
            dfs(mineral+1, 2, 0, cost, temp, minerals);
            
        }
        
        else
            dfs(mineral + 1, pick, pickCount + 1, cost, temp, minerals);
        
        
    }
}