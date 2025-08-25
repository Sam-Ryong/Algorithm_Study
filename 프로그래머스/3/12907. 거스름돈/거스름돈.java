class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[][] DP = new int[n+1][money.length+1];
        
        for (int i = 0; i < money.length; i++){
            DP[money[i]][i+1] = 1;
        }
        
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < money.length+1; j++){
                
                DP[i][j] += DP[i][j-1];

                if (i - money[j-1] >= 0){
                    DP[i][j] += DP[i-money[j-1]][j];     
                }
      
            }
        }
        
        
        
        return DP[n][money.length];
    }
}