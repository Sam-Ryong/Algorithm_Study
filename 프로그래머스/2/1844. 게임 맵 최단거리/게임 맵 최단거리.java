import java.util.*;

class Solution {
    
    int[][] maps;
    
    public int solution(int[][] maps) {
        int answer = 1;
        this.maps = maps;
        
        List<List<Integer>> now = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        now.add(Arrays.asList(0,0));
        
        while (now.size() > 0) {
            boolean end = false;
      
            for (List<Integer> point : now){
                int i = point.get(0);
                int j = point.get(1);
                if (maps[i][j] == 0){
                    continue;
                }
                maps[i][j] = 0;
                if (i == maps.length - 1 && j == maps[0].length - 1){
                    end = true;
                    break;
                }
                if (i > 0){
                    if (maps[i-1][j] == 1)
                        temp.add(Arrays.asList(i-1,j));
                }
                if (j > 0){
                    if (maps[i][j-1] == 1)
                        temp.add(Arrays.asList(i,j-1));
                }
                if (i < maps.length - 1){
                    if (maps[i+1][j] == 1)
                        temp.add(Arrays.asList(i+1,j));
                }
                if (j < maps[0].length - 1){
                    if (maps[i][j+1] == 1)
                        temp.add(Arrays.asList(i,j+1));
                }
            }
            if (end)
                break;
            now.clear();
            now.addAll(temp);
            temp.clear();
            answer++;
            
            if (now.size() == 0)
                answer = -1;
        }
        
        return answer;
    }
    
}