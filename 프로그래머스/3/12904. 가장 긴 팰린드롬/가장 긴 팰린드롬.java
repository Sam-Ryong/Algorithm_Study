import java.lang.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] charlist = s.toCharArray();
        
        for (int i = 0; i < charlist.length; i++){
            
            int maxLength = 1;
            for (int j = i; i - j + i >= 0 && charlist.length > j; j++){
                
                if (i - j + i == 0 || charlist.length - 1 == j){
                    maxLength = 2 * (j - i) + 1;;
                }
                
                if (charlist[j] != charlist[i-j+i]){
                    maxLength = 2 * (j - i) - 1;;
                    break;
                }
                
            }
            
            answer = Math.max(answer, maxLength);
               
        }
        
        for (int i = 1; i < charlist.length; i++){
            
            if (charlist[i] != charlist[i-1])
                continue;
            
            int maxLength = 2;
            for (int j = i+1; j < charlist.length && i-1 - (j - i) >= 0; j++){
                
                if (j == charlist.length - 1 || i-1 - (j - i) == 0){
                    maxLength = 2 * (j - i + 1);
                }
                
                if (charlist[j] != charlist[i-1 - (j - i)]){
                    maxLength = 2 * (j - i);
                    break;
                }
                
            }
             answer = Math.max(answer, maxLength);
               
        }
        
        
        return answer;
    }
}