import java.lang.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        for (int i = 0; i < Integer.toString(storey).length(); i++){
            int c = (int) (storey % Math.pow(10,i + 1)) / (int) Math.pow(10,i);
            if (c < 5){
                answer += c;
            }
            else if (c == 5){
                int a = (int) (storey % Math.pow(10,i + 2)) / (int) Math.pow(10,i+1); 
                if (a <= 4){
                    answer += c;
                }
                else{
                    answer += 10 - c;
                    storey += Math.pow(10,i+1);
                }
            }
            else{
                answer += 10 - c;
                storey += Math.pow(10,i+1);
            }
 
        }
        return answer;
    }
}