import java.lang.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] DP = new int[land.length][4];
        
        DP[0] = land[0];
        
        for (int i = 1; i < land.length; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    if (j != k){
                        DP[i][j] = Math.max(DP[i][j], DP[i-1][k]);
                    }
                }
                DP[i][j] = DP[i][j] + land[i][j];
            }
            
        }
        
        for (int i = 0; i < 4; i++){
            answer = Math.max(answer, DP[land.length-1][i]);
        }

        return answer;
    }
}