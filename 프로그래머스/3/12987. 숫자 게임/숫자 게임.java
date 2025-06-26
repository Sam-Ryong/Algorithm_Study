import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A);
        
        for (int b : B){
            pq.offer(b);
        }
        
        for (int a : A){
            while (!pq.isEmpty() && pq.peek() <= a){
                pq.poll();
            }
            
            if (pq.isEmpty())
                break;
            pq.poll();
            answer++;
        }
        
        return answer;
    }
}