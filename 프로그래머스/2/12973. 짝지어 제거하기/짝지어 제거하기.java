import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        Stack<Character> stack = new Stack();
        stack.push(' ');
        for (char c : s.toCharArray()){
            char a = stack.peek();
            if (a == c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        stack.pop();
        if (stack.isEmpty()){
            return 1;
        }
        
        else{
            return 0;
        }
        
    }
    
}