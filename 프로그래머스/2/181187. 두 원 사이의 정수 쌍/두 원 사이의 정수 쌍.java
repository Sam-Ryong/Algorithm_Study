import java.lang.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long R1 = (long) r1;
        long R2 = (long) r2;
        
        
        for (long x = 1; x <= R2; x++){
            
            long MaxY = (long) Math.floor(Math.sqrt(R2 * R2 - x * x));
            long MinY = (long) Math.ceil(Math.sqrt(R1 * R1 - x * x));
            //System.out.println(MaxY + " " + MinY);
            answer += MaxY - MinY + 1;
        }
           
        return answer * 4;

        
    }
    

}