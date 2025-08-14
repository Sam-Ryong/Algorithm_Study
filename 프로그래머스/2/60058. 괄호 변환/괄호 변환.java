import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        
        
        return make(p);
    }
    
    String make(String p){
        if (p.length() == 0)
            return "";
        
        String u = "";
        String v = "";
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '(')
                countLeft++;
            else
                countRight++;
            
            if (countLeft > 0 && countLeft == countRight){
                u = p.substring(0,i+1);
                if (i < p.length() - 1)
                    v = p.substring(i+1);
                break;
            }
        }
        
        
        if (isCorrect(u)){
            return u + make(v);
        }
        else{
            
            String temp = u.substring(1,u.length() - 1);
            String reversed = "";
            for (int i = 0; i < temp.length(); i++){
                if (temp.substring(i,i+1).equals("("))
                    reversed += ")";
                else
                    reversed += "(";
            }
            
            return  "(" + make(v) + ")" + reversed;
        }
        
        
    }
    
    boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(c);
            }
            else{
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    
}