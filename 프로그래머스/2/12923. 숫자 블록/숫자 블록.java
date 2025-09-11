import java.lang.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end - (int)begin + 1];
        
        for (long i = 0; i < answer.length; i++){
            
            answer[(int) i] = (int) maxGCD(i + begin);
            
        }
        

 
        return answer;
    }
    
    public long maxGCD(long num){
        
        long answer = 1;
        long square = (long) Math.sqrt(num);
        long div = 2;
        if (num == 1l)
            return 0l;
        while (div >= 2 && div <= square){

            if (num % div == 0){
                long partner = num / div;
                if (partner <= 10000000){
                    answer = Math.max(partner, answer);
                    break;
                }
                else{
                    if (div <= 10000000){
                        answer = div;
                    }
                }
                
            }
            div++;
            
        }
        
        return answer;
        
    }
    

    
}