import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations){
            
            if (op.charAt(0) == 'I'){
                int number = Integer.parseInt(op.substring(2));
                
                min.offer(number);
                max.offer(number);           
            }
            else if (op.charAt(0) == 'D'){
                int number = Integer.parseInt(op.substring(2));
                if (number == 1 && !max.isEmpty()){
                    max.poll();
                    List<Integer> temp = new ArrayList<>(max);
                    min.clear();
                    min.addAll(max);    
                }
                else if (number == -1 && !min.isEmpty()){
                    min.poll();
                    List<Integer> temp = new ArrayList<>(min);
                    max.clear();
                    max.addAll(min); 
                }
            }
            
        }
        answer[0] = !max.isEmpty() ? max.peek() : 0;
        answer[1] = !min.isEmpty() ? min.peek() : 0;
        return answer;
    }
}