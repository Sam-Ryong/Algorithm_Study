class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int now = 0;
        int turn = 0;
        while (t > 0){
            // 0 1 10 11 100 101
            // 0   1  1  1 0
            String nString = Integer.toString(now, n).toUpperCase();
            for (char c : nString.toCharArray()){                
                if (turn == p-1){
                    answer += c;
                    t -= 1;
                }
                if (t == 0)
                    break;
                turn = ((turn + 1) % (m));
            }
            now++;
            
        }
        
         
        return answer;
    }
    
}