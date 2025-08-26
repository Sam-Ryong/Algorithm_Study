class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int[] order = new int[a.length];
        int[] reversed = new int[a.length];
        order[0] = a[0];
        reversed[0] = a[a.length-1];
        
        if (a.length == 1)
            return 1;
        
        for (int i = 1; i < a.length; i++){
            
            if (a[i] < order[i-1])
                order[i] = a[i];
            else
                order[i] = order[i-1];
            
            if (a[a.length - 1 - i] < reversed[i-1])
                reversed[i] = a[a.length - 1 - i];
            else
                 reversed[i] =  reversed[i-1];
            
        }
        
//         for (int i = 0; i < a.length; i++){
            
//             System.out.print(order[i] + " ");
            
//         }
        
//         System.out.println();
        
//         for (int i = 0; i < a.length; i++){
            
//             System.out.print(reversed[i] + " ");
            
//         }
        
        for (int i = 1; i < a.length - 1; i++){
            
            if (a[i] < order[i-1] || a[i] < reversed[a.length - i - 2])
                answer++;
            
        }
        
        return answer;
    }
}