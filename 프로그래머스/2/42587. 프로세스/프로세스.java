import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        int max = priorities.length-1;
        LinkedList<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++){

            queue.offer(new Process(priorities[i],i));
        }
        Arrays.sort(priorities);
        
        while (true){
            
            if (queue.size() == 0)
                break;
            Process process = queue.poll();
            if (process.priority < priorities[max]){
                queue.offerLast(process);
            }
            else{
                if (process.location == location)
                    break;
                max--;
                answer++;
            }
            
            
        }
        
        return answer;
    }
    
    class Process{
        int priority;
        int location;
        Process(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
        int getPriority(){
            return priority;
        }
    }
}