import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> main = new Stack<>();
        Stack<Integer> semi = new Stack<>();
        List<Integer> truck = new ArrayList<>();
        
        for (int i = 1; i < order.length+1; i++){
            main.push(order.length+1 - i);
        }

        
        
        int pointer = 0;
        
        while (pointer < order.length){
            
            
            int todo = order[pointer++];
            int begin = truck.size();
            while(!main.isEmpty() && main.peek() <= todo){
                semi.push(main.pop());
            }
            
            
            if (!semi.isEmpty() && semi.peek() == todo){
                truck.add(semi.pop());
            }
            
            if (begin == truck.size())
                break;
            
                    
        }
        
        
        return truck.size();
    }
}