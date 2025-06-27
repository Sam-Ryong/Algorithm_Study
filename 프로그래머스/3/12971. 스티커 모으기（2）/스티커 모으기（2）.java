import java.lang.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int[][] DP = new int[sticker.length][2];
        int[][] DP2 = new int[sticker.length][2];
        
        if (sticker.length == 1)
            return sticker[0];
        if (sticker.length == 2)
            return Math.max(sticker[0], sticker[1]);
        
        if (sticker.length > 1){
            DP[1][0] = 0;
            DP[1][1] = sticker[1];
        }
        if (sticker.length > 2){
            DP[2][0] = DP[1][1];
            DP[2][1] = sticker[2];
        }
        if (sticker.length > 3){
            DP[3][0] = Math.max(DP[2][0], DP[2][1]);
            DP[3][1] = DP[2][0] + sticker[3];
        }

        for (int i = 4; i < sticker.length; i++){
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            DP[i][1] = DP[i-1][0] + sticker[i];
        }
        
        DP2[0][0] = 0;
        DP2[0][1] = sticker[0];
        if (sticker.length > 1){
            DP2[1][0] = DP2[0][1];
            DP2[1][1] = sticker[1];
        }
        if (sticker.length > 2){
            DP2[2][0] = Math.max(DP2[1][1], DP2[1][0]);
            DP2[2][1] =  DP2[1][0] + sticker[2];
        }
        
        for (int i = 3; i < sticker.length - 1; i++){
            DP2[i][0] = Math.max(DP2[i-1][0], DP2[i-1][1]);
            DP2[i][1] = DP2[i-1][0] + sticker[i];
        }
        
        
        int notContainFirst = Math.max(DP[sticker.length-1][0],DP[sticker.length-1][1]);
        int containFirst = Math.max(DP2[sticker.length-2][0],DP2[sticker.length-2][1]);

        return Math.max(notContainFirst,containFirst);
    }
}