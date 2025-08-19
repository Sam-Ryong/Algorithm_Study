import java.lang.*;
import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] board;
    int[][][] DP;
    
    public int solution(int[][] b) {
        
        board = b;
        DP = new int[board.length][board.length][2];
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                
                DP[i][j][0] = Integer.MAX_VALUE;
                DP[i][j][1] = Integer.MAX_VALUE;
                
            }
        }
        
        dfs(0,0,0,"h");
        dfs(0,0,0,"v");
        
        
        return Math.min(DP[board.length-1][board.length-1][0], DP[board.length-1][board.length-1][1]);
    }
    
    void dfs(int i, int j, int cost, String dir){
        
        if (i > board.length - 1 || j > board.length - 1)
            return;
        if (i < 0 || j < 0)
            return;
        
        if (board[i][j] == 1)
            return;
        
        if (dir.equals("v") && DP[i][j][0] > cost){             
            DP[i][j][0] = cost;
            if (dir.equals("v")){
                dfs(i+1,j,cost+100,"v");
                dfs(i-1,j,cost+100,"v");
                dfs(i,j+1,cost+600,"h");
                dfs(i,j-1,cost+600,"h");
            }
            else if (dir.equals("h")){
                dfs(i+1,j,cost+600,"v");
                dfs(i-1,j,cost+600,"v");
                dfs(i,j+1,cost+100,"h");
                dfs(i,j-1,cost+100,"h");
            }
        }  

        if (dir.equals("h") && DP[i][j][1] > cost){             
            DP[i][j][1] = cost;
            if (dir.equals("v")){
                dfs(i+1,j,cost+100,"v");
                dfs(i-1,j,cost+100,"v");
                dfs(i,j+1,cost+600,"h");
                dfs(i,j-1,cost+600,"h");
            }
            else if (dir.equals("h")){
                dfs(i+1,j,cost+600,"v");
                dfs(i-1,j,cost+600,"v");
                dfs(i,j+1,cost+100,"h");
                dfs(i,j-1,cost+100,"h");
            }
        }  

        
    }
    
    
}