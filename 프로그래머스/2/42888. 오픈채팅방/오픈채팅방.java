import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> user = new HashMap<String, String>();
        List<String[]> log = new ArrayList<String[]>();
        
        for (String rec : record){
            
            String[] parse = rec.split(" ");
            String instruction = parse[0];
            String id = parse[1];
            String name = "";
            if (parse.length == 3)
                name = parse[2];
            String[] l = new String[2];
            
            if (instruction.equals("Enter")){
                user.put(id,name);
                l[0] = instruction;
                l[1] = id;
                log.add(l);
            }
            else if (instruction.equals("Leave")){
                l[0] = instruction;
                l[1] = id;
                log.add(l);
            }
            else if (instruction.equals("Change")){
                user.put(id,name);
            }
            
        }
        String[] answer = new String[log.size()];
        for (int i = 0; i < log.size(); i++){
            
            String s = "";
            if (log.get(i)[0].equals("Enter")){
                s = user.get(log.get(i)[1]) + "님이 들어왔습니다.";
            }
            else{
                s = user.get(log.get(i)[1]) + "님이 나갔습니다.";
            }
            answer[i] = s;
            
        }
        
        
        return answer;
    }
}