import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] time = new int[24*60];
        
        for (String[] s : book_time){
            
            int begin = Integer.parseInt(s[0].substring(0,2)) * 60 + Integer.parseInt(s[0].substring(3));
            int end = Integer.parseInt(s[1].substring(0,2)) * 60 + Integer.parseInt(s[1].substring(3));
            
            for (int i = begin; i < Math.min(end + 10,24*60); i++){
                time[i]++;
            }
            
        }
        
        for (int i = 0; i < 24*60; i++){
            if (answer < time[i])
                answer = time[i];
        }
        
        return answer;
    }
}