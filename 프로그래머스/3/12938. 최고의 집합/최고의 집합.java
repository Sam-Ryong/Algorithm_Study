import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        
        int remain = s % n;
        
        int div = s / n;
        
        if (div == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++){
            answer[i] = div;
            if (remain != 0){
                answer[i] += 1;
                remain--;
            }
            
            
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}