import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++){
            int index = -1;
            for (int j = i+1; j < prices.length; j++){
                if (prices[i] > prices[j]){
                    index = j;
                    break;
                }
            }
            if (index < 0)
                answer[i] = prices.length - i - 1;
            else{
                answer[i] = index - i;
            }
            
        }
        
        return answer;
    }
    

}