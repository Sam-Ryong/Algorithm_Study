import java.util.*;

class Solution {
    List<Character> foods = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    List<String> combinations = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
       
        Map<Character, Integer> memory = new HashMap<>();

        for (String order : orders){
            
            for (Character menu : order.toCharArray()){
                if (memory.get(menu) == null){
                    memory.put(menu,1);
                    foods.add(menu);
                }
            }
                 
        }
        
        Collections.sort(foods);
        
        
        for (int c : course){
            dfs("", 0,  c);
            int max = 0;
            List<String> temp = new ArrayList<>();

            for (String combination : combinations){
                int count = 0;
                for (String order : orders){
                    boolean have = true;
                    for (int i = 0; i < combination.length(); i++){
                        if (!order.contains(combination.substring(i,i+1))){
                            have = false;
                            break;
                        }
                    }
                    if (have)
                        count++;       
                }
                if (count >= 2 && count > max){
                    temp.clear();
                    temp.add(combination);
                    max = count;
                }
                else if (count >= 2 && count == max){
                    temp.add(combination);
                }
                
            }
            answer.addAll(temp);

            
            combinations.clear();
        }
        
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    void dfs(String s, int num, int target){
        
        if (s.length() == target){
            combinations.add(s);
            return;
        }
        if (num == foods.size())
            return;
        dfs(s + foods.get(num), num + 1, target);
        dfs(s, num + 1, target);
        
    }
}