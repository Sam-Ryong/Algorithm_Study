import java.util.*;

class Solution {
    
    int[][] matrix;
    int reg = 0;
    public int[] solution(String[] maps) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();
        
        matrix = new int[maps.length][maps[0].length()];
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (maps[i].charAt(j) == 'X'){
                    matrix[i][j] = 0;
                }
                else{
                    matrix[i][j] = Integer.parseInt(maps[i].substring(j,j+1));
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] != 0){
                    explore(i,j);
                    if (reg > 0)
                        list.add(reg);
                    reg = 0;
                }
            }
        }
        if (list.size() == 0)
            list.add(-1);
        Collections.sort(list);
        answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    void explore(int i, int j){
        if (i < 0 || j < 0)
            return;
        if (i > matrix.length - 1 || j > matrix[0].length - 1)
            return;
        if (matrix[i][j] == 0)
            return;
        reg += matrix[i][j];
        matrix[i][j] = 0;
        explore(i + 1, j);
        explore(i - 1, j);
        explore(i, j + 1);
        explore(i, j - 1);
        
    }
}