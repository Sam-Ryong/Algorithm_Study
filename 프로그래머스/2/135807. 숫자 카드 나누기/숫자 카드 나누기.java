import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int low = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int high = Math.max(arrayA[0], arrayB[0]);
        for (int i = high; i > 1; i--){
            
            if (checkTrue(arrayA, i)){
                if (checkFalse(arrayB, i))
                    return i;
            }
            else if (checkTrue(arrayB, i)){ 
                if (checkFalse(arrayA, i))
                    return i;
            }
            
        }
        
        return 0;
    }
    
    public boolean checkTrue(int[] arrayA,  int val){
        
        boolean result = true;
        
        for (int A : arrayA){
            if (A % val != 0){
                result = false;
                break;
            }
        }

        return result;
    }
    
    public boolean checkFalse(int[] arrayA,  int val){
        
        boolean result = true;
        
        for (int A : arrayA){
            if (A % val == 0){
                result = false;
                break;
            }
        }

        return result;
    }
}