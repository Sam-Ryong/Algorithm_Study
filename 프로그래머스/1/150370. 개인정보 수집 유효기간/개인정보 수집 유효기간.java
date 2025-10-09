import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<Integer>();
        int now = parseDate(today);
        Map<String, Integer> expire = new HashMap<>();
        
        for (String term : terms){
            String[] s = term.split(" ");
            expire.put(s[0], Integer.parseInt(s[1]));
        }
        
        for (int i = 0; i < privacies.length; i++){
            String privacy = privacies[i];
            String[] s = privacy.split(" ");
            int date = parseDate(s[0]);
            String name = s[1];
            if(date + expire.get(name) * 28 <= now){
                answer.add(i+1);
            }
        }
        
        int[] temp = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++){
            temp[i] = answer.get(i);
        }
        return temp;
    }
    
    int parseDate(String s){

        String[] arr = s.split("\\.");
    

        return (Integer.parseInt(arr[0]) - 2000) * 28 * 12 + Integer.parseInt(arr[1]) * 28 + Integer.parseInt(arr[2]);
    }
}