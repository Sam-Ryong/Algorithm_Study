import java.lang.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] s1 = new int[sequence.length];
        int[] s2 = new int[sequence.length];
        
        for (int i = 0; i < sequence.length; i++){
            
            s1[i] = sequence[i];
            s2[i] = sequence[i];
            if (i % 2 == 0)
                s1[i] = s1[i] * -1;
            else
                s2[i] = s2[i] * -1;
        }
        
        long[][] DP = new long[s1.length][2];
        DP[0][0] = 0;
        DP[0][1] = s1[0];
        
        for (int i = 1; i < sequence.length; i++){       
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            DP[i][1] = Math.max(DP[i-1][1] + s1[i], s1[i]);   
        }
        
        answer = Math.max(DP[sequence.length - 1][0], (DP[sequence.length - 1][1]));
        
        DP[0][0] = 0;
        DP[0][1] = s2[0];
        
        for (int i = 1; i < sequence.length; i++){       
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            DP[i][1] = Math.max(DP[i-1][1] + s2[i], s2[i]);   
        }
        
        answer = Math.max(answer, Math.max(DP[sequence.length - 1][0], (DP[sequence.length - 1][1])));
                          
        return answer;
    }
}