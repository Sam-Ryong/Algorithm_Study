import java.lang.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long maxX = 0;
        for (long i = 0; i <= d; i += k){
            maxX = i;
        }
        long y = 0;
        for (long i = maxX; i >= 0; i -= k){
            
            long x = i;
           
            
            
            for (long j = y; j <= d; j += k){
                if (Math.sqrt(j*j + i*i) > d)
                    break;
                answer += x / k + 1;

                y += k;
            }
            
        }
        

        return answer;
    }
}