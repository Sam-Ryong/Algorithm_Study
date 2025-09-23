import java.util.*;
import java.lang.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    public int solution(String name) {
        int target = 0;
        for (int i = 0; i < name.length(); i++){
            char c = name.toCharArray()[i];
            list.add(c - 65);
            if (c != 'A')
                target = target | (1 << (name.length() - i - 1));
        }
        

        findMinSchedule(0, 0, target, 0);
    
        for (int x : list){
            answer += Math.min(x, 26 - x);
        }
        
        return answer;
    }
    
    void findMinSchedule(int now, int visit, int target, int count){
        
        if (count > answer)
            return;
        visit = visit | (1 << (list.size() - now - 1));
        
        if ((visit & target) == target){
            answer = Math.min(answer, count);
            return;
        }
        if (count > answer)
            return;
        
        findMinSchedule((now + 1) % list.size(), visit, target, count + 1);
        if (now - 1 < 0)
            findMinSchedule(list.size() - 1, visit, target, count + 1);
        else
            findMinSchedule(now - 1, visit, target, count + 1);
    }
}