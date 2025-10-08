class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        for (int j = 0; j < arr1.length; j++){
            int code = arr1[j];
            String bin = Integer.toBinaryString(code);
            int index = n - 1;
            for (int i = bin.length() - 1; i >= 0; i--){
                if (bin.charAt(i) == '1')
                    map1[j][index] = 1;
                index--;
            }
            
        }
        
        for (int j = 0; j < arr2.length; j++){
            int code = arr2[j];
            String bin = Integer.toBinaryString(code);
            int index = n - 1;
            for (int i = bin.length() - 1; i >= 0; i--){
                if (bin.charAt(i) == '1')
                    map2[j][index] = 1;
                index--;
            }
            
        }
        
        for (int i = 0; i < n; i++){
            String temp = "";
            for (int j = 0; j < n; j++){
                if (map1[i][j] + map2[i][j] >= 1){
                    temp += "#";
                }
                else
                    temp += " ";
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}