import java.util.*;
import java.lang.*;

class Solution {
    int answer = 0;
    List<Integer> candidate = new ArrayList<>();
    public int solution(String[][] relation) {
        
    
        makeCombination(0, relation, 0);

        List<Integer> answerList = new ArrayList<>();
        
        Collections.sort(candidate, (a, b) -> Integer.compare(Integer.bitCount(a), Integer.bitCount(b)));
        
        for (int c : candidate){
            
            boolean hasSubset = false;
            for (int a : answerList){
                if ((a & c) == a){
                    hasSubset = true;
                    break;
                }
            }
            if (!hasSubset)
                answerList.add(c);
            
        }

        return answerList.size();
        
    }
    
    void makeCombination(int now, String[][] relation, int visit){
        
        if (now > relation[0].length){
            return;
        }
        
        Map<List<String>, Integer> map = new HashMap<>();
        for (String[] tuple : relation){
            List<String> fk = new ArrayList<>();

            for (int bits = visit; bits != 0; bits &= bits - 1) {
                int i = Integer.numberOfTrailingZeros(bits);
                fk.add(tuple[i]);
            }
            
            if (fk.size() > 0 && map.get(fk) == null)
                map.put(fk, 1);
        }

        if (map.size() == relation.length){
    
            answer++;
            candidate.add(visit);
            //return;
        }
        
        makeCombination(now + 1, relation, visit);
        makeCombination(now + 1, relation, visit | 1 << now);
        
    }
     
 
}