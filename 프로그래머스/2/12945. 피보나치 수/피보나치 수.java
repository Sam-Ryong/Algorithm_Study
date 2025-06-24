class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int F0 = 0;
        int F1 = 1;
        
        for (int i = 2; i <= n; i++){
            int temp = F1;
            F1 = (F0 + F1) % 1234567;
            F0 = temp;
        }
        
        
        return F1;
    }
}