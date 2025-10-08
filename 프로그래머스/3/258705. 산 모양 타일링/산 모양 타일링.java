class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[][] DP = new int[n][7];
        
        if (tops[0] == 1){
            DP[0][0] = 1;
            DP[0][1] = 1;
            DP[0][2] = 1;
            DP[0][3] = 1;
        }
        else{
            DP[0][4] = 1;
            DP[0][5] = 1;
            DP[0][6] = 1;
        }
       
        
        for (int i = 1; i < n; i++){
            if (tops[i] == 1){
                DP[i][0] = DP[i-1][0] + DP[i-1][1] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5] + DP[i-1][6];
                DP[i][1] = DP[i-1][0] + DP[i-1][1] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5] + DP[i-1][6];
                DP[i][2] = DP[i-1][0] + DP[i-1][1] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5] + DP[i-1][6];
                DP[i][3] = DP[i-1][0] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5];
            }
            else{
                DP[i][4] = DP[i-1][0] + DP[i-1][1] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5] + DP[i-1][6];
                DP[i][5] = DP[i-1][0] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5];
                DP[i][6] = DP[i-1][0] + DP[i-1][1] + DP[i-1][2] + DP[i-1][3] + DP[i-1][4] + DP[i-1][5] + DP[i-1][6];
            }
            for (int j = 0; j < 7; j++){
                DP[i][j] = DP[i][j] % 10007;
            }
        }
        for (int x : DP[n-1]){
            answer += x;
            answer = answer % 10007;
        }
        return answer;
    }
}