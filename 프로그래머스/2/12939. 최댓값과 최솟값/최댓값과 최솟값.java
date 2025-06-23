class Solution {
    public String solution(String s) {
        String answer = "";
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        
        String[] l = s.split(" ");
        
        for (String num : l){
            Integer n = Integer.parseInt(num);
            if (max < n){
                max = n;
            }
            if (min > n){
                min = n;
            }
        }
        
        answer = answer + min.toString() + " " + max.toString();
        
        
        return answer;
        
        
    }
}