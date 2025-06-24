import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length - 10; i++){
            if(checkDiscount(i,discount,want,number)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    boolean checkDiscount(int startday, String[] discount, String[] want, int[] number){
        
        Map<String,Integer> wishList = new HashMap<String,Integer>();
        boolean result = true;
        for (int i = 0; i < want.length; i++){
            wishList.put(want[i],number[i]);
        } 
        for (int i = 0; i < 10; i++){
            String product = discount[startday+i];
            if (wishList.get(product) != null){
                wishList.put(product, wishList.get(product) - 1);
            }
            
        }
        
        for (Integer n : wishList.values()){
            if (n != 0){
                result = false;
                break;
            }
        }
        return result;
    }
}