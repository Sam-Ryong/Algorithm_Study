class Solution {
    int answer = -1;
    int ANSWER = 0;
    public int solution(String word) {
        
        dfs("", word);
        
        return ANSWER;
    }
    
    void dfs(String s, String word){
        if (s.length() > 5)
            return;
        if (s.equals(word)){
            answer++;
            ANSWER = answer;
            return;
        }
        answer++;
        dfs(s+"A", word);
        dfs(s+"E", word);
        dfs(s+"I", word);
        dfs(s+"O", word);
        dfs(s+"U", word);
    }
}