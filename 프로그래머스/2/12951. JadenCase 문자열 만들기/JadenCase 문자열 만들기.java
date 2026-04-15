class Solution {
    public String solution(String s) {
        String answer = "";
        
        answer += s.substring(0,1).toUpperCase();
        for (int i = 1; i < s.length(); i++){
            
            if (s.charAt(i-1) == ' '){
                answer += s.substring(i,i+1).toUpperCase();
            }
            else{
                answer += s.substring(i,i+1).toLowerCase();
            }
            
        }
        
        return answer;
        
    }
}