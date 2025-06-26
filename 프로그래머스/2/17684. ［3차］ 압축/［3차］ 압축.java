import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> output = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 1; i < 27 ; i++){
            dict.put("" + (char) (64 + i), i);
        }
        int now = 0;
        int count = 26;
        
        for (String s : msg.split("")){
            queue.offer(s);
        }
        
        String w = "";
        while (!queue.isEmpty()){
            w = queue.pop();
            while(!queue.isEmpty() && dict.get(w + queue.peek()) != null){
                w = w + queue.pop();
            }
            output.add(dict.get(w));
            dict.put(w + queue.peek(), ++count);
        }
        
        int[] answer = new int[output.size()];
        for (int i = 0; i < output.size(); i++){
            answer[i] = output.get(i);
        }
        
        return answer;
    }
}