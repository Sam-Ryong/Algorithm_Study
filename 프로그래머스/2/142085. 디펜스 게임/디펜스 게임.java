import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);

            if (pq.size() > k) {
                n -= pq.poll(); // 병사를 써야 하는 라운드 중 가장 작은 적 수
            }

            if (n < 0)
                return i; // 이 라운드 진행 불가
        }
        return enemy.length; // 끝까지 버팀
    }
}
