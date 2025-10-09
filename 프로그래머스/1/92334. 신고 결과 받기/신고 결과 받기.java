import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> index = new HashMap<>();
        Map<String, Set<String>> reported = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++){
            String id = id_list[i];
            index.put(id, i);
            reported.put(id, new HashSet<String>());
        }
        
        for (String r : report){
            
            String[] s = r.split(" ");
            reported.get(s[1]).add(s[0]);
            
        }
        
        for (int i = 0; i < id_list.length; i++){
            String id = id_list[i];
            
            if (reported.get(id).size() >= k){
                for (String haha : reported.get(id)){
                    answer[index.get(haha)]++;
                }
            }
            
        }
        
        return answer;
    }
}