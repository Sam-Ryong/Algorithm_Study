import java.lang.*;
import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> set = new HashMap<>();
        String bin = "";
        for (int i = 0; i < numbers.length(); i++){
            bin += "0";
        }
        for (int i = 0; i < numbers.length(); i++){
            permutation("", i, numbers, bin, list);
        }
        for (int num : list){
            if (set.get(num) == null && isPrime(num)){
                
                set.put(num, num);
                answer++;
            }
        }
        return answer;
    }
    
    void permutation(String now, int a, String numbers, String visit, List<Integer> list){
        
        if (visit.charAt(a) == '1')
            return;
        visit = visit.substring(0,a) + '1' + visit.substring(a+1);
        now = now + numbers.charAt(a);
        list.add(Integer.parseInt(now));
        for (int i = 0; i < numbers.length(); i++){
            permutation(now, i, numbers, visit, list);
        }
        
        
    }
    
    boolean isPrime(int number){
        
        boolean result = true;
        int div = 2;
        if (number == 1 || number == 0)
            return false;
        while (div < number){
            if (number % div == 0){
                result = false;
                break;
            }
            div++;
        }
        
        return result;
        
    }
}