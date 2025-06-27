class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++){
            
            long number = numbers[i];
            String bin = Long.toBinaryString(number);
            
            answer[i] = find(number);
            
        }
        
        return answer;
    }
    
    long find(long number){
        String bin = Long.toBinaryString(number);
        long result = -1;
        if (number % 2 == 0)
            result = number+1;
        else{
            int zero = -1;
            int one = 0;
            String temp = "";
            for (int i = 0; i < bin.length(); i++){
                if (bin.charAt(i) == '0'){
                    zero = i;
                }
            }
            if (zero == -1){
                bin = "0" + bin;
                for (int i = 0; i < bin.length(); i++){
                    if (bin.charAt(i) == '0'){
                        zero = i;
                        break;
                    }
                }
            }
            
            for (int i = zero; i < bin.length(); i++){
                if (bin.charAt(i) == '1'){
                    one = i;
                    break;
                }
            }
            for (int i = 0; i < bin.length(); i++){
                if (i == zero)
                    temp += '1';
                else if (i == one)
                    temp += '0';
                else
                    temp += bin.charAt(i);
            }
            result = Long.parseLong(temp,2);
            
        }
        return result;
    }
}