import java.util.*;

class Solution {
    
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        for (int i = 0; i < user_id.length; i++){
            dfs(i,0,user_id,banned_id,0,0);
        }

        return set.size();
    }
    
    void dfs(int a, int b, String[] user_id, String[] banned_id, int consumed, int count){
        
        

        
        consumed = consumed | (1 << a);
        String user = user_id[a];
        String ban = banned_id[b];

        count++;
        if (!able(user, ban))
            return;
        
        if (b == banned_id.length - 1){
            set.add(consumed);
            return;
        }

        for (int i = 0; i < user_id.length; i++){
            if ((consumed & (1 << i)) == 0)
                dfs(i,b+1,user_id,banned_id,consumed,count);
        }
        
    }
    
    boolean able(String a, String b){
        if (a.length() != b.length())
            return false;
        
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) == b.charAt(i) || b.charAt(i) == '*')
                continue;
            else
                return false;
        }
        
        return true;
    }
}