import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 그래프: 출발지 -> (사전순 도착지들)
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        for (String[] t : tickets) {
            g.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }

        Deque<String> stack = new ArrayDeque<>();
        List<String> route = new ArrayList<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String u = stack.peek();
            PriorityQueue<String> pq = g.get(u);
            if (pq != null && !pq.isEmpty()) {
                // 가장 사전순으로 앞선 도착지 선택(티켓 소모)
                stack.push(pq.poll());
            } else {
                // 더 못 나가면 경로 뒤에 쌓기
                route.add(stack.pop());
            }
        }

        // 역순이 정답
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}
