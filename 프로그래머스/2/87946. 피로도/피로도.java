import java.lang.Math;

class Solution {
    int max = Integer.MIN_VALUE;
    int[][] dg;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dg = dungeons;
        String bin = "";
        for (int i = 0; i <dg.length; i++){
            bin += "0";
        }
        for (int i = 0; i < dg.length; i++){
            dfs(k,i,0,bin);
        }
        return max;
    }
    
    void dfs(int k, int now, int count, String visit){
        if (visit.charAt(now) == '1')
            return;
        if (k < dg[now][0]){
            
            return;
        }
       
        visit = visit.substring(0,now) + "1" + visit.substring(now+1);
        count++;
        k -= dg[now][1];
        if (count > max){
            max = count;
        }
        
        for (int i = 0; i < dg.length; i++){
            dfs(k,i,count,visit);
        }
    }
}