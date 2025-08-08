import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int high = 200000000;
        int low = 1;
        
        while (low < high){
            int mid = (low + high) / 2;
            
            int[] temp = new int[stones.length];
            for (int i = 0; i < temp.length; i++){
                temp[i] = Math.max(0, stones[i] - mid);
            }
            int chainZero = -1;
            boolean isAble = true;
            for (int i = 0; i < temp.length; i++){
                if (temp[i] == 0){
                    if (chainZero < 0){
                        chainZero = 1;
                    }
                    else{
                        chainZero++;
                    }
                }
                else{
                    chainZero = -1;
                }
                if (chainZero >= k){
                    isAble = false;
                    break;
                }
                
            }
            
            if (isAble){
                
                answer = mid;
                low = mid + 1;
            }
            else{
                high = mid;
            }
            
            
        }
        
        return answer + 1;
    }
}