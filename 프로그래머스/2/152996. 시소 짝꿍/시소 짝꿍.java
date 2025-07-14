import java.lang.*;
import java.util.*;


class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        Map<Integer,Long> count = new HashMap<>();
        
        for (int i = 0; i < weights.length; i++){
            
            if (count.get(weights[i]) == null ){
                count.put(weights[i],1l);
            }
            else{
                count.put(weights[i],count.get(weights[i]) + 1);
            }
        
        }
        
        weights = new int[count.keySet().size()];
        int[] dweights = new int[weights.length];
        int[] tweights = new int[weights.length];
        int n = 0;
        for (int a : count.keySet()){
            weights[n] = a;
            dweights[n] = weights[n] * 2;
            tweights[n] = weights[n] * 3;
            n++;
        }
        Arrays.sort(weights);
        Arrays.sort(dweights);
        Arrays.sort(tweights);
        
        for (int i = 0; i < weights.length; i++){
            int val = weights[i];
            if (count.get(val) > 1){
                answer += count.get(val) * (count.get(val) - 1) / 2;
            }
            int a = Arrays.binarySearch(dweights, val * 3);
            if (a >= 0){
                answer += 1 * count.get(val) * count.get(weights[a]);
            }
            a = Arrays.binarySearch(dweights, val * 4);
            if (a >= 0){
                answer += 1 * count.get(val) * count.get(weights[a]);
            }
            a = Arrays.binarySearch(tweights, val * 4);
            if (a >= 0){
                answer += 1 * count.get(val) * count.get(weights[a]);
            }
            
        }
        
        return answer;
    }
    
   
}