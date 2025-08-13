import java.util.*;

class Solution {
    String[][] tickets;
    List<String> best = new ArrayList<>();
    public String[] solution(String[][] t) {
        String[] answer = new String[t.length+1];
        tickets = t;
        String used = "";
        for (int i = 0; i < tickets.length; i++){
            used += "0";
        }
        for (int i = 0; i < tickets.length; i++){
            if (tickets[i][0].equals("ICN")){
                
                List<String> temp = new ArrayList<>();
                temp.add("ICN");
                dfs(i, used, temp);
            }
        }
        
         for (int i = 0; i < tickets.length + 1; i++){
            answer[i] = best.get(i);
        }
        
        
        
        return answer;
    }
    

    
    void dfs(int now, String used, List<String> list){
        
        if (used.charAt(now) == '1'){
            if (list.size() == tickets.length + 1){
                if (best.size() == 0){
                    best.addAll(list);
                }
                else{
                    
                    boolean isSmall = false;
                    for (int i = 0; i < tickets.length + 1; i++){
                        int cmp = best.get(i).compareTo(list.get(i));
                        if (cmp == 0)
                            continue;
                        else if (cmp > 0){
                            isSmall = true;
                            break;
                        }
                        else
                            break;
                    }
                    if (isSmall){

                        best.clear();
                        best.addAll(list);
                    }
                        
                }
            
            }
            return;
        }

        List<String> temp = new ArrayList<>();
        temp.addAll(list);
        temp.add(tickets[now][1]);
        used = used.substring(0,now) + "1" + used.substring(now+1);
        
        
        
        for (int i = 0; i < tickets.length; i++){
            if (tickets[now][1].equals(tickets[i][0]) || list.size() == tickets.length)
                dfs(i, used, temp);
            
        }

    }
    
    
}