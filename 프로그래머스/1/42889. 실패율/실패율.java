import java.util.*;

class Solution {
    public Integer[] solution(int N, int[] s) {
        Integer[] answer = new Integer[N];
        
        Integer[] stages = new Integer[s.length];
        Double[] rate = new Double[N+1];
        for (int i = 0; i < s.length; i++){
            stages[i] = s[i];
        }
        Arrays.sort(stages);
        
        // for (int i = 0; i < stages.length; i++){
        //     System.out.print(stages[i] + " ");
        // }
        // System.out.println();
        
        for (int i = 1; i <= N; i++){
            answer[i-1] = i;

            int x = lowerBound(stages, i);
            int y = lowerBound(stages, i+1);
            double mom = stages.length - x;
            double son = y - x;
            if (mom == 0.0)
                rate[i] = 0.0;
            else
                rate[i] = son/mom;
            
        }
        
        Arrays.sort(answer,(a,b) -> {
            int cmp = Double.compare(rate[b], rate[a]);
            if (cmp == 0)
                return Integer.compare(a,b);
            return Double.compare(rate[b], rate[a]);
        });
        return answer;
    }
    
    int lowerBound(Integer[] stages, int value){
        int low = 0;
        int high = stages.length;
        
        while (low < high){
            int mid = (low + high) / 2;
            
            if (stages[mid] >= value){
                high = mid;
            }
            else{
                low = mid + 1;
            }
            
        }
        return low;
    }
}