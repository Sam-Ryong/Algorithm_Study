import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        answer[numbers.length - 1] = -1;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[numbers.length - 1]);
        
        for (int i = numbers.length - 2; i >= 0; i--){
            
            if (numbers[i] < numbers[i+1]){
                answer[i] = numbers[i+1];
            }
            else{
                while(!stack.isEmpty() && stack.peek() <= numbers[i]){
                    stack.pop();
                }
                answer[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(numbers[i]);
        }

        
        return answer;
        
    }
    
}