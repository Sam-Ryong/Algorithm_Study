import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        
        for (int t : topping){
            if (right.get(t) == null){
                right.put(t,1);
            }
            else{
                right.put(t,right.get(t) + 1);
            }
        }
        
        for (int i = 0; i < topping.length; i++){
            
            int now = topping[i];
            if (left.get(now) == null){
                left.put(now,1);
            }
            else{
                left.put(now,left.get(now) + 1);
            }
            
            if (right.get(now) == 1){
                right.remove(now);
            }
            else{
                right.put(now, right.get(now) - 1);
            }
            
            if (left.values().size() == right.values().size()){
                answer++;
            }
        }
        
        
        
        return answer;
    }
    
}