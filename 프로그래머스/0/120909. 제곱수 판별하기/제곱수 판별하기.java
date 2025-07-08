import java.lang.*;

class Solution {
    public int solution(int n) {
        int m = 1;
        int answer = 2;
        while (m <= Math.sqrt(n)){
            if (n == m*m){
                answer = 1;
                break;
            }
            m++;
        }
        return answer;
    }
}