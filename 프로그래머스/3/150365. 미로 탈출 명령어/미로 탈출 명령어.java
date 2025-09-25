import java.lang.*;

class Solution {
    String answer = "";
    int N;
    int M;
    int R;
    int C;
    int K;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        
        if ((Math.abs(x - r) + Math.abs(y - c)) % 2 != k % 2)
            return "impossible";
        
        if ((Math.abs(x - r) + Math.abs(y - c)) > k)
            return "impossible";
        
        dfs(x,y,"");
        
        return answer;
    }
    
    void dfs(int i, int j, String path){
        
        if (i < 1 || j < 1 || i > N || j > M)
            return;

        if (!answer.isEmpty() && path.compareTo(answer) > 1){
            return;
        }
        
        if ((Math.abs(i - R) + Math.abs(j - C)) > K - path.length())
            return;
        
        if (path.length() == K){
            if (i == R && j == C){
                if (answer.isEmpty())
                    answer = path;
                else {
                    if (answer.compareTo(path) > 0)
                        answer = path;
                }
            }
           
            return;
        }
        
        
        dfs(i+1, j, path+"d");
        dfs(i, j-1, path+"l");
        dfs(i, j+1, path+"r");
        dfs(i-1, j, path+"u");

    }
}