import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] parse = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String num : parse){
            max = Math.max(max, Integer.parseInt(num));
            min = Math.min(min, Integer.parseInt(num));
        }
        
        answer += String.valueOf(min);
        answer += " ";
        answer += String.valueOf(max);
    
        
        
        return answer;
        
        
    }
}