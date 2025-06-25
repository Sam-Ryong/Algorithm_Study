import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<String>();
        
        for (String city : cities){
            if (cacheSize >= 1)
                answer += process(cache, cacheSize, city.toUpperCase());
            else
                answer += 5;
        }
        
        return answer;
    }
    
    int process(List<String> cache, int cacheSize, String city){
        boolean found = false;
        int index = -1;
        for (int i = 0; i < cache.size(); i++){
            String data = cache.get(i);
            if (data.equals(city)){
                found = true;
                index = i;
                break;
            }
        }
        if (found){ //cache hit 일 경우
            cache.remove(index);
            cache.add(city);
            return 1;
        }
        
        if (!cache.isEmpty() && cache.size() >= cacheSize){
            cache.remove(0);
        }
        cache.add(city);
        return 5;
         
    }
}