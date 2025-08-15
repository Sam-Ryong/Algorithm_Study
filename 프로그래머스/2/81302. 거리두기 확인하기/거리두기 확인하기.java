class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int now = 0;
        for (String[] place : places){
            int value = 1;
  
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 3; j++){
                    if (place[i].substring(j,j+1).equals("P") && place[i].substring(j+2,j+3).equals("P")){
                        if (!place[i].substring(j+1,j+2).equals("X"))
                            value = 0;
                    }
                    
                    if (place[i].substring(j,j+2).equals("PP") || place[i].substring(j+1,j+3).equals("PP")){
                        value = 0;
                    }
                }      
            }
            
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 5; j++){
                    if (place[i].substring(j,j+1).equals("P") && place[i+2].substring(j,j+1).equals("P")){
                        if (!place[i+1].substring(j,j+1).equals("X"))
                            value = 0;
                    }
                    if (place[i].substring(j,j+1).equals("P") && place[i+1].substring(j,j+1).equals("P")){
                        value = 0;
                    }
                    if (place[i+1].substring(j,j+1).equals("P") && place[i+2].substring(j,j+1).equals("P")){
                        value = 0;
                    }
                }      
            }
            
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (place[i].substring(j,j+1).equals("P") && place[i+1].substring(j+1,j+2).equals("P")){
                        if (!(place[i].substring(j+1,j+2).equals("X") && place[i+1].substring(j,j+1).equals("X")))
                            value = 0;
                    }
                    if (place[i].substring(j+1,j+2).equals("P") && place[i+1].substring(j,j+1).equals("P")){
                        if (!(place[i].substring(j,j+1).equals("X") && place[i+1].substring(j+1,j+2).equals("X")))
                            value = 0;
                    }
                }      
            }
            answer[now++] = value;
        }
        
        return answer;
    }
    
    
}