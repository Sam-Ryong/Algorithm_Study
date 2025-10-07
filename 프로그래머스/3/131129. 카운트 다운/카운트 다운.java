import java.util.*;

class Solution {
    int[] answer = new int[2];
    public int[] solution(int target) {
        answer[0] = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] DP = new int[target+1][2];

        
        for (int i = 1; i < 21; i++){
            if (map.get(i) == null)
                map.put(i,1);
        }
        
        for (int i = 1; i < 21; i++){
            if (map.get(2 * i) == null)
                map.put(2 * i, 0);
            if (map.get(3 * i) == null)
                map.put(3 * i, 0);
        }
        
        for (int key : map.keySet()){
            if (key <= target){
                DP[key][0] = 1;
                DP[key][1] = map.get(key);
            }
        }
        try{
            DP[23][0] = 2;
            DP[23][1] = 2;
            DP[25][0] = 2;
            DP[25][1] = 2;
            DP[29][0] = 2;
            DP[29][1] = 2;
            DP[31][0] = 2;
            DP[31][1] = 2;
            DP[35][0] = 2;
            DP[35][1] = 2;
            DP[37][0] = 2;
            DP[37][1] = 2;
            DP[41][0] = 2;
            DP[41][1] = 1;
            DP[43][0] = 2;
            DP[43][1] = 1;
            DP[44][0] = 2;
            DP[44][1] = 1;
            DP[46][0] = 2;
            DP[46][1] = 1;
            DP[47][0] = 2;
            DP[47][1] = 1;
            DP[49][0] = 2;
            DP[49][1] = 1;
            DP[50][0] = 1;
            DP[50][1] = 1;
            DP[52][0] = 2;
            DP[52][1] = 2;
            DP[53][0] = 2;
            DP[53][1] = 2;
            DP[55][0] = 2;
            DP[55][1] = 2;
            DP[56][0] = 2;
            DP[56][1] = 2;
            DP[58][0] = 2;
            DP[58][1] = 2;
            DP[59][0] = 2;
            DP[59][1] = 2;
        }
        catch(Exception e){
            
        }
        
        for (int i = 61; i < target + 1; i++){
            
      
            DP[i][0] = DP[i - 50][0] + DP[50][0];
            DP[i][1] = DP[i - 50][1] + DP[50][1];
            
            for (int j = 1; j <= 60; j++){
                 if (DP[i-j][0] + DP[j][0] < DP[i][0]){
                    DP[i][0] = DP[i-j][0] + DP[j][0];
                    DP[i][1] = DP[i - j][1] + DP[j][1];
                }
            }    
            
        }

        
        return DP[target];
    }
    
   
}