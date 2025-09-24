import java.util.*;

class Solution {
    int maxDif = Integer.MIN_VALUE;
    int[] answer = {};
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(0, n, ryan, info);
        
        if (answer.length == 0)
            answer = new int[]{-1};
        return answer;
    }
    
    
    public void dfs(int now, int arrows, int[] ryan, int[] info){
        if (arrows == 0 || now == 10){

            if (now == 10 && arrows != 0)
                ryan[10] = arrows;
            int ryanPoint = 0;
            int apeachPoint = 0;
            for (int i = 0; i < 11; i++){
                
                if (info[i] == 0 && ryan[i] == 0)
                    continue;

                if (info[i] >= ryan[i]){
                    apeachPoint += 10 - i;
                }
                   
                else if (info[i] < ryan[i])
                    ryanPoint += 10 - i;
            }
            
            int diff = ryanPoint - apeachPoint;
            if (diff <= 0)
                return;
            if (diff > maxDif){
                maxDif = diff;
                answer = ryan.clone();
            }
            else if (diff == maxDif){
                boolean is = false;
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > answer[i]) {
                        is = true;
                        break;
                    }
                    else if (ryan[i] < answer[i]) {
                        is = false;
                        break;
                    }
                }
                
                if (is){
                    answer =ryan.clone();
                }
                
            }
  
            return;
        }
        
        for (int i = 0; i <= arrows; i++){
            int[] temp = ryan.clone();
            temp[now] = i;
            dfs(now + 1, arrows - i, temp, info);
        }
        
    }
}