import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        List<Integer> temp = new ArrayList<>();
        
        int[][] map = new int[rows+1][columns+1];
        
        int count = 1;
        for (int i = 1; i < rows+1; i++){
            for (int j = 1; j < columns+1; j++){
                map[i][j] = count++;
            }
        }
        
        for (int[] q : queries){
            int x1 = q[0];
            int y1 = q[1];
            int x2 = q[2];
            int y2 = q[3];
            int keep = map[x1][y1];
            int min = keep;
            for (int i = x1; i < x2; i++){
                map[i][y1] = map[i+1][y1];
                if (map[i][y1] < min)
                    min = map[i][y1];
            }
            for (int j = y1; j < y2; j++){
                map[x2][j] = map[x2][j+1];
                if (map[x2][j] < min)
                    min = map[x2][j];
            }
            for (int i = x2; i > x1; i--){
                map[i][y2] = map[i-1][y2];
                if (map[i][y2] < min)
                    min = map[i][y2];
            }
            for (int j = y2; j > y1; j--){
                map[x1][j] = map[x1][j-1];
                if (map[x1][j] < min)
                    min = map[x1][j];
            }
            map[x1][y1+1] = keep;
            
            temp.add(min);
        }
        
        answer = new int[temp.size()];
        
        for (int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}