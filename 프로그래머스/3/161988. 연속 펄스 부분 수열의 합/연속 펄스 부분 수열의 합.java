import java.lang.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int N = sequence.length;
        long[][] DP = new long[N][2];
        
        DP[0][1] = sequence[0];
        
        for (int i = 1; i < N; i++){
            int op = 1;
            if (i % 2 == 1)
                op = -1;
            
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            
            DP[i][1] = Math.max(DP[i-1][1] + sequence[i] * op, sequence[i] * op);
        }
        
        answer = Math.max(DP[N-1][0], DP[N-1][1]);
        
        DP = new long[N][2];
        DP[0][1] = -sequence[0];
        for (int i = 1; i < N; i++){
            int op = 1;
            if (i % 2 == 0)
                op = -1;
            
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            
            DP[i][1] = Math.max(DP[i-1][1] + sequence[i] * op, sequence[i] * op);
        }
        
        answer = Math.max(answer, Math.max(DP[N-1][0], DP[N-1][1]));
        
        return answer;
    }
}