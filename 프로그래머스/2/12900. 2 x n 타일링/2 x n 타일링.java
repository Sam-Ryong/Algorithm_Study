class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] DP = new int[n];
        
        DP[0] = 1;
        DP[1] = 2;
        
        for (int i = 2; i < n; i++){
            DP[i] = (DP[i-2] % 1000000007 + DP[i-1] % 1000000007) % 1000000007;
        }
        return DP[n-1];
    }
}