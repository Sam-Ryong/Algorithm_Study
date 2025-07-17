class Solution {
    public String solution(int n) {
        String answer = "";
        
        while (true){
            n = n - 1;
            int b = n % 3;
            int a = n / 3;
            // a * 3 + b
            if (b == 0)
                answer = "1" + answer;
            else if (b == 1)
                answer = "2" + answer;
            else if (b == 2)
                answer = "4" + answer;
               
            n = a;
            if (a == 0){
                break;
            }
        }
        
        return answer;
    }
}