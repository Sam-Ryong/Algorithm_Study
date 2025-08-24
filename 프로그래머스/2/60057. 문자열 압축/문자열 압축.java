class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if (s.length() == 1)
            return 1;
        
        for (int i = 1; i <= s.length() / 2; i++){
            String result = "";
            int count = 1;
            String prev = s.substring(0,i);
            for (int j = i; j <= s.length() - i; j = j + i){
                
                String now = s.substring(j,j+i);
                if (now.equals(prev)){
                    count++;
                }
                else{
                    if (count > 1)
                        result += count;
                    count = 1;
                    result += prev;
                    prev = now;
                }
                
            }
            if (count == 1)
                result += prev;
            else
                result += count + prev;
            result += s.substring(s.length() - s.length() % i);
            if (answer > result.length())
                answer = result.length();
        }
        
        return answer;
    }
}