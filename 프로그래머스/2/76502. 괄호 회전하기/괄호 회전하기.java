import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++){
            if (isOkay(s)){
                answer++;
            }
            s = rotate(s);
        }
        return answer;
    }
    
    String rotate(String s){
        return s.substring(1)+s.substring(0,1);
    }
    
    boolean isOkay(String s){
        
        Stack<Character> stack = new Stack();
        
        char[] array = s.toCharArray();
        
        for (char c : array){                 
            
            if (stack.size() > 0 && isMatch(stack.peek(),c)){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        
        
        
        return stack.isEmpty();
        
    }
    
    boolean isMatch(char a, char b){
        if (a == '[' && b == ']'){
            return true;
        }
        else if (a == '(' && b == ')'){
            return true;
        }
        else if (a == '{' && b == '}'){
            return true;
        }
        else{
            return false;
        }
    }
}