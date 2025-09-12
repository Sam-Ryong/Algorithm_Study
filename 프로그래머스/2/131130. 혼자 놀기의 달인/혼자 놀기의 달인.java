import java.util.*;

class Solution {
    
    boolean[] opened;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        opened = new boolean[cards.length];
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= cards.length; i++){
            if (!opened[i-1]){
                int x = findGroup(i, cards);
                temp.add(x);
            }
        }
        
        Collections.sort(temp);
        
        if (temp.size() == 1)
            return 0;
        
        return temp.get(temp.size()-1) * temp.get(temp.size() - 2);
    }
    
    public int findGroup(int i, int[] cards){
        
        int result = 0;
        
        int now = i;
        
        while (opened[now-1] == false){
 
            opened[now-1] = true;
            result = result + 1;
            
            now = cards[now-1];
        }
        
        return result;
   
    }
}