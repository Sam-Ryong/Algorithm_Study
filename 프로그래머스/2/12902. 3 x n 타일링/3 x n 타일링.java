class Solution {
    public int solution(int n) {
        int answer = 0;
        
        long[][] DP = new long[n+1][3];
        
        DP[0][0] = 1;
        DP[2][0] = 3;
        DP[2][2] = 4;
        DP[4][0] = 9;
        DP[4][1] = 2;
        DP[4][2] = 15;
        
        for (int i = 6; i <= n; i = i + 2){
;
            DP[i][0] = ((DP[i-2][0] + DP[i-2][1]) * 3) % 1000000007;
            
            DP[i][1] = DP[i-4][2] * 2;
            DP[i][1] = DP[i][1] % 1000000007;
            
            DP[i][2] = (DP[i-2][2] + DP[i][0] + DP[i][1]) % 1000000007;

        }

        
        return (int) (DP[n][0] + DP[n][1]) % 1000000007;
    }
}