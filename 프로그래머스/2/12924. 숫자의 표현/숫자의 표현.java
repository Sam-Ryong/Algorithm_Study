class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n+1; i++){
            if(possible(i,n)){
                answer++;
            }
        }
        return answer;
    }
    
    boolean possible(int size, int num){
        int a = (int) num / size;
        double b = (double)num / (double)size;
        
        if (size % 2 == 0) {
            if (b - size/2 < 0)
                return false;
            if (b - a == 0.5)
                return true;
            else
                return false;
        }
        else{
            if (b - size/2 <= 0)
                return false;
            return (b - a == 0.0);
        }
      
            
    }
}