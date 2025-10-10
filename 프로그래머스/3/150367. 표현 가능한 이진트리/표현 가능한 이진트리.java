class Solution {
    boolean temp = true;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        /*
            일단, 홀수번째 비트가 이제 리프 노드야
            
            그리고 부모 노드 번째수 구하는법 : 자식 두개 더하고 2로 나누면 됨
            
            자식중 적어도 하나가 1이면 부모가 0인게 말이 안됨 ㅇㅇ 
            
            이걸로 푸는거 인듯~!
        */
        
        for (int i = 0; i < numbers.length; i++){
            
            long number = numbers[i];
            String bin = Long.toBinaryString(number);
            
            
            int len = bin.length();
            int x = 1;
            while (x < len){
                x = (x + 1) * 2 - 1;
            }
            for (int j = 0; j < x - len; j++){
                bin = "0" + bin;
            }
            
            int root = (bin.length() + 1) / 2;
            
            check(root, bin, root, false);
            
            if (temp)
                answer[i] = 1;
            temp = true;
        }
        
        

        return answer;
    }
    
    void check(int now, String bin, int d, boolean noMore){
        
        d = d / 2;
        
        
        if (!noMore && bin.charAt(now-1) == '0'){
            noMore = true;
        }
        else if (noMore && bin.charAt(now-1) == '1'){
            temp = false;
            return;
        }
        
        if (now % 2 == 1){
            return;
        }
        check(now - d, bin, d, noMore);
        check(now + d, bin, d, noMore);
        
    }
}