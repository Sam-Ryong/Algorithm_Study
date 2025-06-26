import java.lang.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    String[] words;
    String begin;
    String target;
    public int solution(String begin, String target, String[] words) {
        
        
        this.begin = begin;
        this.target = target;
        String[] temp = new String[words.length + 1];
        temp[0] = begin;
        for (int i = 1; i < words.length + 1; i++){
            temp[i] = words[i-1];
        }
        this.words = temp;
        String visit = "";
        for (int i = 0; i < words.length + 1; i++){
            visit = visit + "0";
        }
        
        
        dfs(0,0,visit);
        if (answer == Integer.MAX_VALUE)
            answer = 0;
        
        return answer;
    }
    
    void dfs(int now, int count, String visit){
        
        
        if (words[now].equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        
        if (visit.charAt(now) == '1')
            return;
        
        visit = visit.substring(0,now) + '1' + visit.substring(now+1);
        for (int i = 0; i < words.length; i++){
            if (i != now && ableToConvert(words[now], words[i]))
                dfs(i, count + 1, visit);
        }
        
    }

    
    boolean ableToConvert(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}