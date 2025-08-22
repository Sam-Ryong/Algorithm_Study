class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for (int i = 0; i < s.length(); i++){
            
            int low = i;
            int high = i;
            boolean changed = true;
            
            while (changed){
                changed = false;
                if (high < s.length() - 1 && low > 0 && s.charAt(low - 1) == s.charAt(high + 1)){
                    changed = true;
                    low--;
                    high++;
                }
            }
       
            if (answer < high - low + 1)
                answer = high - low + 1;    
        }
        
        for (int i = 0; i < s.length() - 1; i++){
            
            int low = i;
            int high = i+1;
            boolean changed = true;
            
            if (s.charAt(low) != s.charAt(high))
                continue;
            
            while (changed){
                changed = false;
                if (high < s.length() - 1 && low > 0 && s.charAt(low - 1) == s.charAt(high + 1)){
                    changed = true;
                    low--;
                    high++;
                }
            }
       
            if (answer < high - low + 1)
                answer = high - low + 1;    
        }
        

        
        return answer;
    }
}