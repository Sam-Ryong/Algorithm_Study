import java.util.*;

class Solution {
    public int solution(int[][] t) {
        int answer = 1;
       
        
        Comparator<Integer[]> cmp = (a,b) -> {
            if (!a[0].equals(b[0]))
                return Integer.compare(b[0], a[0]);
            else{
                return Integer.compare(a[1], b[1]);
            }
        };
        
        Integer[][] scores = new Integer[t.length][3];
        
        
        for (int i = 0; i < t.length; i++){
            scores[i][0] = t[i][0];
            scores[i][1] = t[i][1];
            scores[i][2] = i;
        }
        
        Arrays.sort(scores, cmp);
        int max = -1;
        for (int i = 0; i < scores.length; i++){
            
            if (max > scores[i][1]){
                if (scores[i][2] == 0){
                    return -1;
                }
                scores[i][2] = -1;
            }
            else{
                max = scores[i][1];
            }
        }

        
        for (int i = 0; i < scores.length; i++){
            if (scores[i][2] != -1){
                if (scores[i][0] + scores[i][1] > t[0][0] + t[0][1])
                    answer++;
            }
        }

  
        return answer;
    }
}