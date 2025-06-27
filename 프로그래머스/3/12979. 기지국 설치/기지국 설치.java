import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int index = 0;
        int covered = 0;
        while (index < stations.length){
            
            int station = stations[index++];
            int coverage = 2 * w + 1;
            
            int needToCover = station - w - covered - 1;
            
            if (station - w - 1 <= covered){
                covered = station + w; 
                continue;
            }
            
            answer += needToCover / coverage;
            if (needToCover % coverage != 0)
                answer += 1;
            
            covered = station + w;    
            if (covered >= n)
                break;
        }
        
        if (covered >= n)
            return answer;
        
        int coverage = 2 * w + 1;
            
        int needToCover = n - covered;
            
        answer += needToCover / coverage;
        if (needToCover % coverage != 0)
            answer += 1;
        
        return answer;
             
    }
}