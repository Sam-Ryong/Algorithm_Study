import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();        
        
        
        for (int size = 1; size < elements.length; size++){            
            for (int i = 0; i < elements.length; i++){
                int sum = 0;
                for (int j = 0; j < size; j++){
                    sum += elements[(i+j) % elements.length];
                }
                if (map.get(sum) == null){
                    map.put(sum, 1);
                }
            }
        }

        return map.values().size() + 1;
    }
}