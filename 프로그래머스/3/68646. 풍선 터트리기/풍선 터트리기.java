import java.lang.*;

class Solution {
    public int solution(int[] a) {
        int answer = 2;
        
        int[] DP1 = new int[a.length];
        int[] DP2 = new int[a.length];
        
        DP1[0] = a[0];
        DP2[a.length - 1] = a[a.length-1];
        
        for (int i = 1; i < a.length; i++){
            DP1[i] = Math.min(DP1[i-1], a[i]);
            DP2[a.length - 1 - i] = Math.min(DP2[a.length - i], a[a.length - 1 - i]);
        }
        
        for (int i = 1; i < a.length - 1; i++){
            
            if (a[i] < DP1[i-1] || a[i] < DP2[i+1])
                answer++;
            
        }
        
        return answer;
        
        
    }
}