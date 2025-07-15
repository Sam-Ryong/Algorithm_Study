import java.util.*;

class Solution {
    public int solution(String[] s) {
        int answer = 0;
        char[][] maps = new char[s.length][s[0].length()];
        Integer[] start = new Integer[2];
        Integer[] lever = new Integer[2];
        
        for (int i = 0; i < s.length; i++){       
            maps[i] = s[i].toCharArray();   
            for (int j = 0; j <s[0].length(); j++){
                if (maps[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if (maps[i][j] == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        List<Integer[]> now = new ArrayList<>();
        List<Integer[]> temp = new ArrayList<>();
        now.add(start);
        int[][] visit = new int[s.length][s[0].length()];
        int count = 0;
        boolean find = false;
        while (!now.isEmpty()){
            
            for (Integer[] a : now){
                int i = a[0];
                int j = a[1];
                if (visit[i][j] == 1)
                    continue;
                visit[i][j] = 1;
                
                if (maps[i][j] == 'L'){
    
                    find = true;
                    break;
                }
                else if (maps[i][j] != 'X'){
               
                    if (i >= 1)
                        temp.add(new Integer[]{i-1,j});
                    if (j >= 1)
                        temp.add(new Integer[]{i,j-1});
                    if (i < s.length - 1)
                        temp.add(new Integer[]{i+1,j});
                    if (j < s[0].length() - 1)
                        temp.add(new Integer[]{i,j+1});
                }    
            }
            
            now.clear();
            now.addAll(temp);
            temp.clear();
            
            if (find)
                break;
            count++;
        }
        
        if (!find)
            return -1;
        
        answer += count;
        
        now = new ArrayList<>();
        temp = new ArrayList<>();
        now.add(lever);
        visit = new int[s.length][s[0].length()];
        count = 0;
        find = false;
        while (!now.isEmpty()){
            
            for (Integer[] a : now){
                int i = a[0];
                int j = a[1];
                
                if (visit[i][j] == 1)
                    continue;
                visit[i][j] = 1;
                
                if (maps[i][j] == 'E'){
    
                    find = true;
                    break;
                }
                else if (maps[i][j] != 'X'){
    
                    if (i >= 1)
                        temp.add(new Integer[]{i-1,j});
                    if (j >= 1)
                        temp.add(new Integer[]{i,j-1});
                    if (i < s.length - 1)
                        temp.add(new Integer[]{i+1,j});
                    if (j < s[0].length() - 1)
                        temp.add(new Integer[]{i,j+1});
                }    
            }
            
            now.clear();
            now.addAll(temp);
            temp.clear();
            
            if (find)
                break;
            count++;
        }
        
        if (!find)
            return -1;
        
        answer += count;
        
        
        return answer;
    }
    
    
}