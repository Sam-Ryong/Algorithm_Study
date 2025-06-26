import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : works){
            pq.offer(num);
        }
        
        while (n > 0){
            if (pq.isEmpty()){
                break;
            }
            int work = pq.poll();
            work--;
            if (work != 0)
                pq.offer(work);
            n--;
        }
        
        while (!pq.isEmpty()){
            int num = pq.poll();
            answer += num * num;
        }
        
        
        return answer;
    }
}