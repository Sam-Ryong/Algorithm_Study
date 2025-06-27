class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 999999999;
        int low = 0;
        int high = 0;
        int now = sequence[0];
        while (high < sequence.length && low < sequence.length){
 

            if (now < k){
                if (high == sequence.length - 1)
                    break;
                high++;
                now += sequence[high];    

            }
            else if (now > k){
                now -= sequence[low];
                low++;             
            }
            else{
                if (answer[1] - answer[0] > high - low){
                    answer[0] = low;
                    answer[1] = high;
                }
                now -= sequence[low];
                low++;              
            }
            
        }
        return answer;
    }
}