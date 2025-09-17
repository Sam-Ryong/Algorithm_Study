import java.util.*;

class Solution {
    public int solution(int[][] t) {
        int answer = -1;
        
        int[] target = new int[]{t[0][0], t[0][1]};
        List<Integer[]> list = new ArrayList<>();
        
        Comparator<int[]> cmp = (a, b) ->{
            if (a[0] != b[0])
                return Integer.compare(b[0],a[0]);
            else
                return Integer.compare(a[1], b[1]);
                
        };
        
        Arrays.sort(t, cmp);
        list.add(new Integer[]{t[0][0], t[0][1]});
        int maxSecond = t[0][1];
        for (int i = 1; i < t.length; i++){
            if (t[i][1] < maxSecond){
                continue;
            }
            else{
                list.add(new Integer[]{t[i][0], t[i][1]});
                maxSecond = t[i][1];
            }
                
        }
        
        Collections.sort(list, (b, a) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        
        
        int rank = 1;
        int count = 1;

        for (Integer[] score : list){
            if (target[0] + target[1] == score[0] + score[1]){
                if (target[0] == score[0] && target[1] == score[1]){
                    answer = rank;
                    break;
                }
            }
            else {
                rank++;
            }
  
        }
        
        return answer;
    }
}