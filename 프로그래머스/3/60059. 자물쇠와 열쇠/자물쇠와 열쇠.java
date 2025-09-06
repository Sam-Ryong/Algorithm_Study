import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int[][] map = new int[key.length + key.length + lock.length][key.length + key.length + lock.length];
        
        for (int i = key.length; i < key.length + lock.length; i++){
            for (int j = key.length; j < key.length + lock.length; j++){
                map[i][j] = lock[i - key.length][j - key.length];
            }
        }
        
        answer = checkMatch(key,map);
        
 
        for (int i = 0; i < 4; i++){
            if (checkMatch(key,map)){
                answer = true;
                break;
            }
            key = rotate(key);
                
        }     
        
        return answer;
    }
    public int[][] rotate(int[][] key){
        
        int[][] temp = new int[key.length][key.length];
        int center = key.length / 2;
        
        for (int i = 0 ; i < key.length; i++)
            temp[i] = key[i].clone();
        
        for (int i = 0 ; i < key.length; i++){
            for (int j = 0 ; j < key.length; j++){
                temp[j][key.length - 1 - i] = key[i][j];
            }
        }
             
        return temp;
        
    }
    
    public boolean checkMatch(int[][] key, int[][] map){
        
        boolean result = false;
        for (int i = 1; i < map.length - key.length; i++){
            for (int j = 1; j < map.length - key.length; j++){
                int[][] temp = new int[map.length][map.length];
                for (int k = 0; k < map.length; k++){
                    temp[k] = map[k].clone();
                }
                if (match(key, temp, i, j)){
                    result = true;
                    break;
                }
            }
        }  
        return result;
    }
    
    public boolean match(int[][] key, int[][] map, int i, int j){
        
        boolean result = true;
        
        for (int x = 0; x < key.length; x++){
            for (int y = 0; y < key.length; y++){
                if (map[x+i][y+j] == 1 && key[x][y] == 1){
                    result = false;
                    return result;
                }
                else if (map[x+i][y+j] == 0 && key[x][y] == 1){
                    map[x+i][y+j] = 1;
                }
                    
            }
        }
        
        for (int x = key.length; x < map.length - key.length; x++){
            for (int y = key.length; y < map.length - key.length; y++){
                if (map[x][y] == 0){
                    result = false;
                    break;
                }
                    
            }
        }
        return result;
        
        
    }
}