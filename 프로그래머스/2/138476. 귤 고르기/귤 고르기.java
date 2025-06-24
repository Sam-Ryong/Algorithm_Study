import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 1. 크기별로 개수 세기
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        // 2. 개수만 모아서 정렬 (내림차순)
        List<Integer> countList = new ArrayList<>(map.values());
        countList.sort(Collections.reverseOrder());

        // 3. 많이 나오는 것부터 차례로 더함
        int total = 0;
        for (int count : countList) {
            total += count;
            answer++;
            if (total >= k) break;
        }

        return answer;
    }
}
