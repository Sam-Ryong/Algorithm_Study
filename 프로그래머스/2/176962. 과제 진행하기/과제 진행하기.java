import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer;
        
        Stack<Task> stack = new Stack<>();
        PriorityQueue<Task> pq = new PriorityQueue<Task>(
            (a, b) -> Integer.compare(a.start,b.start)
        );
        List<String> result = new ArrayList<>();
        
        
        
        for (String[] plan : plans){
            
            String name = plan[0];
            Integer start = parseTime(plan[1]);
            Integer playtime = Integer.parseInt(plan[2]);
            
            pq.offer(new Task(name, start, playtime));
            
        }
        int time = pq.peek().start;
        Task now = pq.poll();
        
        while (now != null || !pq.isEmpty() || !stack.isEmpty()){
            
            if (now != null)
                now.playTime -= 1;
            time++;
            
            if (now != null && now.playTime == 0){
                result.add(now.name);
                now = null;
            }
            
            if (!pq.isEmpty() && time == pq.peek().start){
                if (now != null)
                    stack.push(now);
                now = pq.poll();
      
            }
            
            else if (now == null && !stack.isEmpty()){
                now = stack.pop();
            }
            

            
        }
        
        answer = new String[result.size()];
        
        for (int i = 0; i < answer.length; i++){
            
            answer[i] = result.get(i);
            
        }
        
        
        return answer;
    }
    
    class Task{
        
        public String name;
        public Integer start;
        public Integer playTime;
        
        public Task(String name, Integer start, Integer playTime){
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
        
    }
    
    private Integer parseTime(String s){
        
        Integer HH = Integer.parseInt(s.substring(0,2));
        Integer mm = Integer.parseInt(s.substring(3));
        
        return HH * 60 + mm;
        
    }
}