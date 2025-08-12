import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] f = new long[n+1];
        List<Integer> numbers = new ArrayList<>();
        
        for (int i = 1; i < n+1; i++){
            numbers.add(i);
        }
        f[1] = 1;
        for (int i = 2; i < n + 1; i++){
            f[i] = f[i-1] * i;
        }
        

        k = k - 1;
        for (int i = n - 1; i >= 1; i--){
            answer[n-1-i] = numbers.get((int)(k / f[i]));
            numbers.remove((int)(k / f[i]));
            k = k % f[i];
        }
        
        answer[n-1] = numbers.get(0);

        
        
        return answer;
    }
}