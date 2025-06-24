import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int) (right - left + 1)];
        int index = 0;
        
        int si = (int) (left / n + 1);
        int sj = (int) (left % n + 1);
        int ei = (int) (right / n + 1);
        int ej = (int) (right % n + 1);
        
        while (true){
            
            answer[index++] = Math.max(si,sj);
            if ((si == ei && sj == ej)){
                break;
            }
            sj++;
            if (sj > n){
                sj = 1;
                si++;
            }
            
            
        }
        
        System.out.println(si + " " + sj);
        System.out.println(ei + " " + ej);
        
        
        return answer;
    }
}