import java.lang.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> hash = new HashMap<String, Integer>();
        List<String> pb = Arrays.asList(phone_book);
        pb.sort((o1,o2) -> Integer.compare(o2.length(), o1.length()));
        
        for (String number : pb){
            if (hash.get(number) != null){
                answer = false;
                break;
            }
            for (int i = 0; i < number.length(); i++){
                hash.put(number.substring(0,i+1),1);
            }
        }
        
        return answer;
    }
}