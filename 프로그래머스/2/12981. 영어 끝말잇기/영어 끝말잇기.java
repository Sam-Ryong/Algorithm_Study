class Solution {
    public int[] solution(int n, String[] words) {
    
        int turn = 0;
        for (int i = 1; i < words.length; i++){
            
            String before = words[i-1];
            String word = words[i];
            if (before.charAt(before.length()-1) != word.charAt(0)){
                turn = i;
                break;
            }
            for (int j = 0; j < i; j++){
                if (words[j].equals(word)){
                    turn = i;
                    break;
                }
            }
            if (turn > 0){
                break;
            }
            
        }
        int[] answer = {0,0}; 
        if (turn > 0){
            answer[0] = (turn % n) + 1;
            answer[1] = turn / n + 1;      
            
        }
        return answer;
    }
}