import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Double> memory = new ArrayList<>();
        memory.add(0.0);
        while (k != 1){
            int now = 0;
            if (k % 2 == 0)
                now = k / 2;
            else
                now = k * 3 + 1;
            
            memory.add(memory.get(memory.size()-1) + (double) (now + k) / 2);
            k = now;
        }

        int n = memory.size() - 1;
        
        for (int i = 0; i < ranges.length; i++){
            int[] range = ranges[i];
            int a = range[0];
            int b = range[1];
            
            if (n + b < a)
                answer[i] = -1.0;
            
            else
                answer[i] = memory.get(n + b) - memory.get(a);
            
            
        }
        
        return answer;
    }
}