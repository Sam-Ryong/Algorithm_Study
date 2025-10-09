import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < room_number.length; i++){
            long want = room_number[i];
            
            if (map.get(want) == null){
                map.put(want, want+1);
                answer[i] = want;
            }
            else{
                long target = map.get(want);
                while(map.get(target) != null){
                    target = map.get(target);
                }
                answer[i] = target;
                map.put(target, target + 1);
                
                while(map.get(want) != target){
                    long temp = want;
                    want = map.get(want);
                    map.replace(temp, target + 1);
                    
                }
            }
            
        }
        
        
        
        return answer;
    }

    
    
}