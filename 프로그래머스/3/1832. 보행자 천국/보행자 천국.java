class Solution {
    int MOD = 20170805;

    int answer = 0;
    public int solution(int M, int N, int[][] cityMap) {
        
        int[][][] DP = new int[M][N][2];
    
        DP[0][0][0] = 1;
        // DP[0][0][1] = 1;
        /*
            DP[i][j] = 
        */
        for (int i = 0; i < M ; i++){
            for (int j = 0; j < N; j++){
                if (i == 0 && j == 0)
                    continue;
                
                if (cityMap[i][j] == 1){
                    DP[i][j][0] = 0;
                    DP[i][j][1] = 0;
                }
                
                else{
                    if (i > 0){
                        if (cityMap[i-1][j] == 2){
                            DP[i][j][1] += DP[i-1][j][1];
                        }
                        else{
                            DP[i][j][1] += DP[i-1][j][0] + DP[i-1][j][1];
                        }
                        DP[i][j][1] = DP[i][j][1] % MOD;
                    }
                    
                    if (j > 0){
                        if (cityMap[i][j-1] == 2){
                            DP[i][j][0] += DP[i][j-1][0];
                        }
                        else{
                            DP[i][j][0] += DP[i][j-1][0] + DP[i][j-1][1];
                        }
                        DP[i][j][0] = DP[i][j][0] % MOD;
                    }
                }
                
            }
        }
        
//         for (int i = 0; i < M; i++){
//             for (int j = 0; j < N; j++){
//                 System.out.print(DP[i][j][0] + DP[i][j][1] + " ");
//             }
//             System.out.println();
//         }
        

        return (DP[M-1][N-1][0] +  DP[M-1][N-1][1]) % MOD;
    }
    

}