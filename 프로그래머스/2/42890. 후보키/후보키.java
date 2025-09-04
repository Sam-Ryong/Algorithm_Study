import java.util.*;
import java.lang.*;

class Solution {


    public int solution(String[][] relation) {
        int answer = 0;
        
        int M = relation[0].length;
          
        int mask = 0;
        
        int x = (int) Math.pow(2,M);
        
        List<Integer> result = new ArrayList<>();
        List<Integer> realResult = new ArrayList<>();
        
        while (mask < x){
            Map<List<String>, Integer> map = new HashMap<>();
            for (String[] tuple : relation){
                List<String> temp = new ArrayList<>();
                
                for (int bits = mask; bits != 0; bits &= bits - 1){
                    int i = Integer.numberOfTrailingZeros(bits);
                    temp.add(tuple[tuple.length - 1 - i]);
                } 
                
                if (map.get(temp) == null){
                    map.put(temp, 1);
                }
                else
                    break;
            }
            
            if (map.size() == relation.length){
                result.add(mask);
            }
            
            mask++;  
        }

        result.sort((a, b) -> Integer.compare(Integer.bitCount(a), Integer.bitCount(b)));
        

        List<Integer> minimal = new ArrayList<>();
        for (int m : result) {
            boolean hasSubsetKey = false;
            for (int k : minimal) {
                if ((m & k) == k) { hasSubsetKey = true; break; }
            }
            if (!hasSubsetKey) minimal.add(m);
        }

        return minimal.size();
        
    }
     
 
}