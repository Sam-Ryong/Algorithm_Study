

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int size = number.length() - k;
        int start = 0;
        int[] numbers = new int[number.length()];
        for (int i = 0; i < number.length(); i++){
            numbers[i] = Integer.parseInt(number.substring(i,i+1));
        }
        
        while (answer.length() < size){
            int a = findMaxBetween(start, start + k + 1, numbers);
            
            k = k - (a - start);
            start = a + 1;
            answer.append(number.charAt(a));
            
        }
        
        
        return answer.toString();
    }
    
    int findMaxBetween(int start, int end, int[] s){
        int max = -1;
        int result = -1;
        
        for (int i = start; i < end; i++){
            if (s[i] > max){
                max = s[i];
                result = i;
            }
        }
        
        return result;
        
    }
}