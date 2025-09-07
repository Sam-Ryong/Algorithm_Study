import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[0], b[0]);
        });
        
        for (int i = 0; i < targets.length; i++){
            int[] target = targets[i];
            int s = target[0];
            int e = target[1];
            if (s == -1)
                continue;
            for (int j = i + 1; j < targets.length; j++){
                if (targets[j][0] == -1)
                    continue;
                if (targets[j][0] < e){
                    targets[j][0] = -1;
                    targets[j][1] = -1;        
                }
                    
                    
            }
            answer++;
        }
     
        
        return answer;
    }
}