import java.lang.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] DP = new int[board.length][board[0].length];
        DP[0] = board[0];
        for (int i = 0; i < board.length; i++){
            DP[i][0] = board[i][0];
        }
        for (int i = 1; i < DP.length; i++){
            for (int j = 1; j < DP[0].length; j++){
                if (board[i][j] == 0){
                    DP[i][j] = 0;
                    continue;
                }
                if (DP[i-1][j] > 0 && DP[i][j-1] > 0 && DP[i-1][j-1] > 0){
                    DP[i][j] = Math.min(DP[i-1][j], Math.min(DP[i][j-1], DP[i-1][j-1])) + 1;
                }
                else{
                    DP[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < DP.length; i++){
            for (int j = 0; j < DP[0].length; j++){
                if (DP[i][j] > answer)
                    answer = DP[i][j];
            }
        }


        return answer * answer;
    }
}