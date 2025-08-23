import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int low = 9 * 60;
        int high = 23 * 60 + 59;
        
        Comparator<String> cmp = (a, b) -> {
            return Integer.compare(parseTime(a),parseTime(b));
        };
        PriorityQueue<String> que = new PriorityQueue<>(cmp);
        
        for (String time : timetable){
            que.offer(time);
        }
   
        for (int mid = high; mid >= 0; mid--) {
            
            boolean possible = false;
            PriorityQueue<String> temp = new PriorityQueue<>(cmp);
            temp.addAll(que);
            for (int i = 0; i < t * n; i += t){
                
                int busTime = 9 * 60 + i;
                int count = 0;
                while(!temp.isEmpty()){
                    
                    if (parseTime(temp.peek()) <= busTime && parseTime(temp.peek()) <= mid){
                        temp.poll();
                        count++;
                    }
                    else{
                        break;
                    }
                    
                    if (count == m)
                        break;
                    
                }
                if (busTime >= mid && count < m)
                    possible = true;
                if (possible)
                    break;
            }
            if (possible){
                answer = intToTime(mid);
                break;  
            }
        }
        
        return answer;
    }
    
    
    
    int parseTime(String s){
        return Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3));
    }
    
    String intToTime(int time){
        String HH = "0" + time / 60;
        if (HH.length() == 3) HH = HH.substring(1);
        String mm = "0" + time % 60;
        if (mm.length() == 3) mm = mm.substring(1);
        return HH + ":" + mm;
    }
}