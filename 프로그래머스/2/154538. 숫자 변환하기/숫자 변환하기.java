import java.util.*;

class Solution {
   
    public int solution(int x, int y, int n) {
        
        int answer = -1;
        List<Integer> now = new ArrayList<>();
        now.add(x);
        Map<Integer,Integer> temp = new HashMap<>();
        
        int count = 0;
        while (now.size() > 0){
            
            for (int num : now){
                if (num == y){
                    answer = count;
                    break;
                }
                else{
                    if (num + n <= y)
                        temp.put(num + n,num + n);
                    if (num * 2 <= y)
                        temp.put(num * 2, num * 2);
                    if (num * 3 <= y)
                        temp.put(num * 3, num * 3);
                }        
            }
            
            if (answer != -1)
                break;
            
            now.clear();
            now.addAll(temp.values());
            temp.clear();
            count++;
            
        }
        
        return answer;
    }
    
}