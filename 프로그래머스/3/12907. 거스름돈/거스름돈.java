import java.lang.*;

class Solution {
    public int solution(int n, int[] money) {
    
        int[][] DP = new int[n + 1][money.length + 1];
        
        for (int i = 1; i < DP[0].length; i++){
            
            DP[0][i] = 1;
            
        }

        for (int i = 1; i < DP.length; i++){
            
            for (int j = 1; j < DP[0].length; j++){
                
                int coin = money[j-1];
                
                if (i - coin >= 0){
                    DP[i][j] = (DP[i-coin][j] + DP[i][j-1]) % 1000000007;
                }
                else{
                    DP[i][j] = DP[i][j-1];
                }
                
            }
            
        }
        

        
        return DP[n][money.length] ;
    
    }
}