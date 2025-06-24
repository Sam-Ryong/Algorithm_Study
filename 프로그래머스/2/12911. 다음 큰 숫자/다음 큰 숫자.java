class Solution {
    public int solution(int n) {
        int answer = 0;
        String bin = Integer.toBinaryString(n);
        Integer oneCount = 0;
        for (char c : bin.toCharArray()){
            if (c == '1'){
                oneCount++;
            }
        }

        while (true){
            n++;
            Integer howMany = 0;
            for (char c : Integer.toBinaryString(n).toCharArray()){
                if (c == '1'){
                    howMany++;
                }
            }
            if (howMany == oneCount){
                answer = n;
                break;
            }
            
        }
        return answer;
    }
}