import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++){
            
            String a = s[i];
            String b = process(a);
            
            while (true){
                if (a.equals(b))
                    break;
                a = b;
                b = process(a);
            }
            
            answer[i] = b;
            
        }
        return answer;
    }
    
    String process(String s){
        
        if (s.length() <= 3)
            return s;
        
        String result = s;
        String[] data = s.split("");
        List<Integer> memory = new ArrayList<>();
        StringBuilder remain = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            remain.append(data[i]);
            
            if (remain.length() >= 3 &&
                remain.charAt(remain.length() - 1) == '0' &&
                remain.charAt(remain.length() - 2) == '1' &&
                remain.charAt(remain.length() - 3) == '1'){
                remain.delete(remain.length() - 3, remain.length());
                count++;
            }
        
        }
        String str = remain.toString();

        StringBuilder st = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            if (str.charAt(i) == '0'){
                st.append(str.substring(0,i+1));
                for (int j = 0; j < count; j++){
                    st.append("110");
                }
                st.append(str.substring(i+1));
                break;
            }
        }
        if (st.length() == 0){
            for (int j = 0; j < count; j++){
                st.append("110");
            }
            st.append(str);
        }

        
        return st.toString();
    }
}