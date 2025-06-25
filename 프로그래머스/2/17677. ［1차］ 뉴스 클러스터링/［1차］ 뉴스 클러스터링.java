import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        answer = cross(makeSet(str1.toUpperCase()),makeSet(str2.toUpperCase()));
        return answer;
    }
    
    List<String> makeSet(String s){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length()-1; i++){
            String elem = s.substring(i,i+2);
            if (Character.isAlphabetic(elem.charAt(0)) && Character.isAlphabetic(elem.charAt(1)))
                result.add(elem);
            
        }
        return result;
    }
    
    int cross(List<String> a, List<String> b){
        Map<String, Integer> map = new HashMap<>();
        int cross = 0;
        int sum = a.size() + b.size();
        if (a.size() == 0 && b.size() == 0)
            return 65536;
        
        for (String s : a){
            if (map.get(s) == null)
                map.put(s, 1);
            else
                map.put(s,map.get(s) + 1);
        }
        
        for (String s : b){
            if (map.get(s) != null){
                map.put(s,map.get(s) - 1);
                cross++;
                sum--;
                if (map.get(s) == 0){
                    map.remove(s);
                }
            }
        }
        
        return (int)(((double) cross / (double) sum) * 65536);
    }
}