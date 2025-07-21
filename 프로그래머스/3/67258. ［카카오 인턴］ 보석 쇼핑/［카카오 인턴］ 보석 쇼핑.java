import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        Map<String, Integer> kind = new HashMap<>();
        for (String g : gems){
            if (kind.get(g) == null)
                kind.put(g,1);
        }
        int low = 0;
        int high = 0;
        int count = kind.size();
        kind = new HashMap<>();
        while (low <= high && high <= gems.length - 1){
            
            if (kind.get(gems[high]) == null)
                    kind.put(gems[high], 1);
                else
                    kind.put(gems[high], kind.get(gems[high]) + 1);
            high++;
            
            while (count == kind.size()){              
                if (kind.get(gems[low]) == 1)
                    kind.remove(gems[low]);
                else
                    kind.put(gems[low], kind.get(gems[low]) - 1);
                low++;
                if (answer[1] - answer[0] > high - low){
                    answer[0] = low;
                    answer[1] = high;
                }
            }
        }
        
        
        return answer;
    }
}