import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int size = 0;
        for (int i = 1; i < n + 1; i++){
            size += i;
        }
        int[] answer = new int[size];
        
        int level = 1;
        int now = n;
        int currentCount = n;
        int where = 0;
        String edge = "left";
        for (int i = 1; i <= size; i++){
            /*
            [1,2,0,3,0,10,5,6,7,9]
            [1,2,9,3,10,8,4,5,6,7]
            */
            answer[where] = i;
            now--;
            if (now > 0){
                if (edge.equals("left")){
                    where = where + level;
                    level++;
                }
                else if (edge.equals("down")){
                    where = where + 1;
                }
                else if (edge.equals("right")){
                    where = where - level;
                    level--;
                }
            }
            else{
                currentCount--;
                now = currentCount;
                if (edge.equals("left")){
                    edge = "down";
                    where = where + 1;
                }
                else if (edge.equals("down")){
                    edge = "right";
                    where = where - level;
                    level--;
                }
                else if (edge.equals("right")){
                    edge = "left";
                    where = where + level;
                    level++;
                } 
            }
            
            
            
        }

        
        
        
        return answer;
    }
}