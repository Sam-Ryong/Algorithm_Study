class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] DP = new long[n+1];
        
        DP[1] = 1;
        if (n >= 2){
            DP[2] = 2;
        }
        for (int i = 3; i < n+1; i++){
            DP[i] = DP[i-1] % 1234567 + DP[i-2] % 1234567;
        }
    
        return DP[n] % 1234567;
    }
}