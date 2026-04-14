import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
       
        String[] list = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < list.length; i++){
            int x = Integer.parseInt(list[i]);
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        
        return min + " " + max;
    }
}